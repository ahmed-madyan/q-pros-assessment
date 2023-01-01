package utilities.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.waits.Waits;

import java.util.List;
import java.util.Objects;

public class ElementActions {

    public static WebElement findElement(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return Objects.requireNonNull(DriverManager.getDriver()).findElement(elementLocator);
    }

    public static List<WebElement> findElements(By elementLocator) {
        try {
            Waits.waitForAllElementsToBeVisible(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return Objects.requireNonNull(DriverManager.getDriver()).findElements(elementLocator);
    }

    public static void click(By elementLocator) {
        try {
            Waits.waitForElementToBeClickable(elementLocator);
            findElement(elementLocator).click();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void forceClick(By elementLocator) {
        try {
            Waits.waitForElementToBeClickable(elementLocator);
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", findElement(elementLocator));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void type(By elementLocator, String text) {
        try {
            findElement(elementLocator).sendKeys(text);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static String getText(By elementLocator) {
        try {
            return findElement(elementLocator).getText();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
            return null;
        }
    }
}