package utilities;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ListenerWithReport implements ITestListener {

    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    private static String resultPath = getResultPath();

    //Handling File's NullPointerExeption by creating a File
    private static String getResultPath(){
        resultPath = "test";
        if (! new File(resultPath).isDirectory())
            new File(resultPath);

            return resultPath;
    }

    public void onTestStart(ITestResult result) {
        extentTest = extentReports.startTest(result.getMethod().getMethodName());
        extentTest.log(LogStatus.INFO, result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(LogStatus.PASS, "...onTestSuccess...");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.log(LogStatus.FAIL, "...onTestFailure...");
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(LogStatus.SKIP, "...onTestSkipped...");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        extentTest.log(LogStatus.FAIL, "...onTestFailedButWithinSuccessPercentage...");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest.log(LogStatus.FAIL, "...onTestFailedWithTimeout...");
    }

    //Report
    String reportLocation = "test-output/Report/" + resultPath + "/";
    public void onStart(ITestContext context) {
        extentReports = new ExtentReports(reportLocation + "ExtentReport.html");
        extentTest = extentReports.startTest("");
    }

    public void onFinish(ITestContext context) {
        extentReports.endTest(extentTest);
        extentReports.flush();
    }
}
