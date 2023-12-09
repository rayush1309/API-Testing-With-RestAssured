package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITest;
import org.testng.ITestResult;

public class FailedRetryListener implements IRetryAnalyzer {

    private  int retryCount=0;
    private static  final int maxRetryCount=2;


    public boolean retry(ITestResult result){
       if (retryCount<maxRetryCount){
           retryCount++;
           return true;

        }
       return false;

    }

}
