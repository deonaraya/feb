package com.deo.feb.listeners;

import com.deo.feb.Common.CommonHelper;
import com.deo.feb.Common.DriverFactory;
import com.deo.feb.Common.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by chandrad on 2/6/17.
 */

public class TestListener implements IExecutionListener, ITestListener, IInvokedMethodListener {

    private long startTime ;
    WebDriver driver = null ;
    static final Logger LOGGER = LogManager.getLogger(TestListener.class.getName());

    @Override
    public void onExecutionStart() {
        startTime = System.currentTimeMillis();
        System.out.println("TestNG is going to start");
        LOGGER.info("Starting Execution");

    }

    @Override
    public void onExecutionFinish() {
        LOGGER.info("Finished execution");
        System.out.println("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("on test method " +  getTestMethodName(result) + " start");
        LOGGER.info(getTestMethodName(result) + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " success");
        LOGGER.info(getTestMethodName(result) + " succeeded");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test method " + getTestMethodName(result) + " has failed");
        LOGGER.info(getTestMethodName(result) + " has failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test method " + getTestMethodName(result) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("test failed but within success % " + getTestMethodName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("on start of test " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("on finish of test " + context.getName());
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();


    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String browserName =method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
        driver = DriverFactory.getBrowserInstance(browserName);
        DriverManager.setWebDriver(driver);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {


            try {
                LOGGER.info( testResult.getMethod().getMethodName() +  "method failed capturing the screenshot");
                String screenshot = captureScreenshot(CommonHelper.timeStamp(testResult.getName() + "_"));
            } catch (IOException ex) {
                LOGGER.error(ex + "FAILED Capturing Screenshot");
            }
        }
        //else if (testResult.getStatus() == ITestResult.SKIP)


        if (DriverManager.getDriver() != null) {
            LOGGER.info("Finished execution of test :" + method.getTestMethod().getMethodName()
                    + ":with Thread Id: " + Thread.currentThread().getId());
            DriverManager.getDriver().quit();

        }
    }


    public String captureScreenshot(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        LOGGER.info("Screenshot captured");
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = "./ErrorScreenshot/" + screenshotName + ".png";
        LOGGER.info("copying screenshot in repo folder");
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        return dest;
    }
}
