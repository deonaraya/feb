package com.deo.feb.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

/**
 * Created by chandrad on 2/3/17.
 */
public class TestListener implements ITestListener, IExecutionListener, IInvokedMethodListener {


    static final Logger LOGGER = LogManager.getLogger(TestListener.class.getName());

    public void onExecutionStart() {
        LOGGER.info("Execution Started");

    }

    public void onExecutionFinish() {
        LOGGER.info("Execution Finished");

    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {



    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void onTestStart(ITestResult result) {

        LOGGER.info("Test Started : " + result.getClass().getName() + result.getMethod().getMethodName() );
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test Passed successfully : " + result.getClass().getName() + result.getMethod().getMethodName() );
    }

    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test Failed  : " + result.getClass().getName() + result.getMethod().getMethodName() );
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Test Skipped : " + result.getClass().getName() + result.getMethod().getMethodName() );
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOGGER.info("Test Failed with condition : " + result.getClass().getName() + result.getMethod().getMethodName() );
    }

    public void onStart(ITestContext context) {
        LOGGER.info("Test on Start : " + context.getClass().getName());
    }

    public void onFinish(ITestContext context) {
        LOGGER.info("Test on finish : " + context.getClass().getName());

    }
}
