package utilities.driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.exception_handling.ExceptionHandling;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver = null;

    public static void launchChrome() {
        try {
            driver = new ChromeDriver();
            maximizeWindow();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void launchFirefox() {
        try {
            driver = new FirefoxDriver();
            maximizeWindow();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void launchEdge() {
        try {
            driver = new EdgeDriver();
            maximizeWindow();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void maximizeWindow() {
        try {
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void navigate(String url) {
        try {
            getDriver().navigate().to(url);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
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

    public static void quit() {
        try {
            assert driver != null;
            getDriver().quit();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}
