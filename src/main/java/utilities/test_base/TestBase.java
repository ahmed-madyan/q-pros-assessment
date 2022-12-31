package utilities.test_base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Helper;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.reader_manager.properties_reader.ConfigUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    private static WebDriver driver;

    @BeforeMethod
    public static void setUpDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to(ConfigUtils.get_PortalURL());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        try {
            assert driver != null;
            return driver;
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
            return null;
        }
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
            driver.quit();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}