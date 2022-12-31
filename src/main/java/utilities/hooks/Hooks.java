package utilities.hooks;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.helper.Helper;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.reader_manager.properties_reader.ConfigUtils;

import java.io.IOException;

public class Hooks extends AbstractTestNGCucumberTests {
    @BeforeMethod
    public void setUpDriver() {
        DriverManager.launchChrome();
        DriverManager.navigate(ConfigUtils.get_PortalURL());
    }


    public void takesScreenshots(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                Helper.captureScreenshot(DriverManager.getDriver(), result.getName() + "-Failed");
            } catch (IOException e) {
                ExceptionHandling.handleException(e);
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            try {
                Helper.captureScreenshot(DriverManager.getDriver(), result.getName() + "-Passed");
            } catch (IOException e) {
                ExceptionHandling.handleException(e);
            }
        }
    }

    @AfterMethod
    public void tearDownDriver(ITestResult result) {
        try {
            takesScreenshots(result);
            DriverManager.quit();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}