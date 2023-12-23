package core;

import com.relevantcodes.extentreports.LogStatus;
import helper.BaseTestHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReport;

import java.io.IOException;

public class BaseTest {
    @BeforeSuite(alwaysRun = true)
    public void config() throws IOException {
        //create the Path in which we will create folder to keep Html Reports
        String subFolderPath=System.getProperty("user.dir")+"/reports/"+ BaseTestHelper.TimeStamp();
        //create subfolder
        BaseTestHelper.createFolder(subFolderPath);
        ExtentReport.initialize(subFolderPath+"/"+"API_Execution_Automation.html");


    }

    @AfterMethod(alwaysRun = true)
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReport.extentlog.log(LogStatus.PASS, "Test Cases: " + result.getName() + " is Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReport.extentlog.log(LogStatus.FAIL, "Test Cases: " + result.getName() + " is Failed");
            ExtentReport.extentlog.log(LogStatus.FAIL, "Test Cases is Failed due to: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReport.extentlog.log(LogStatus.SKIP, "Test Cases is Skipped: " + result.getName());
        }
        ExtentReport.extentReport.endTest(ExtentReport.extentlog);
        ExtentReport.extentlog.log(LogStatus.INFO, "Test execution completed");
        ExtentReport.extentReport.flush();
    }

    @AfterSuite
    public void endReport(){

        ExtentReport.extentReport.close();


    }

}
