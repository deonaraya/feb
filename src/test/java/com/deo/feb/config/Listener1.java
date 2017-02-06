package com.deo.feb.config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;

/**
 * Created by chandrad on 2/6/17.
 */

public class Listener1 implements IExecutionListener, ITestListener, IInvokedMethodListener {

    private long startTime ;
    WebDriver driver = null ;

    @Override
    public void onExecutionStart() {
        startTime = System.currentTimeMillis();
        System.out.println("TestNG is going to start");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("on test method " +  getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("on test method " + getTestMethodName(result) + " failure");
        System.out.println("Taking Screenshot");
        String methodName=result.getName().toString().trim();
        CaptureScreenShot(result);


    }

    public void CaptureScreenShot(ITestResult result){

//        Object obj  = result.getInstance();
//        driver = ((tryTests) obj).getDriver();

        try {
            TakesScreenshot ts =(TakesScreenshot)driver;

            // Call method to capture screenshot  // save ctrl+ s
            File source= ts.getScreenshotAs(OutputType.FILE);

            // Copy files to specific location here it will save all screenshot in our project home directory and
            // result.getName() will return name of test case so that screenshot name will be same
            FileUtils.copyFile(source, new File("./Screenshots/"+result.getName() + System.currentTimeMillis() +".png"));
            System.out.println("Screenshot taken");

        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
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

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}
