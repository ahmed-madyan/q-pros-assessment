package utilities.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;

import java.time.Duration;
import java.util.Objects;

public class Waits {
    private static final WebDriverWait webDriverWait = new WebDriverWait(Objects.requireNonNull(DriverManager.getDriver()), Duration.ofSeconds(30));

    public static void waitForElementToBeVisible(By elementLocator) {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void waitForAllElementsToBeVisible(By elementLocator) {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void waitForElementToBeClickable(By elementLocator) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void waitForAlertToBeVisible() {
        try {
            webDriverWait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}