package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import core.BaseTest;

import java.io.File;

public class ExtentReport extends BaseTest {
    public static ExtentReports extentReport =null;
    public static ExtentTest extentlog;
    public static void initialize(String extentConfigXmlpath){
        if (extentReport == null){
            extentReport= new ExtentReports(extentConfigXmlpath,true);
            extentReport.addSystemInfo("Host Name",System.getProperty("user.name"));
            extentReport.addSystemInfo("Environment","Preprod3");
            extentReport.addSystemInfo("OS","Mac OS X");
            extentReport.loadConfig(new File(System.getProperty("user.dir") + "/resources/extent-config.xml"));



        }
    }

}
