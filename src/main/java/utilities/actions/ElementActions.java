package utilities.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.waits.Waits;

import java.util.List;

public class ElementActions {

    public static WebElement findElement(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElement(elementLocator);
    }

    public static List<WebElement> findElements(By elementLocator) {
        try {
            Waits.waitForElementsToBeVisible(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElements(elementLocator);
    }

    public static void click(By elementLocator) {
        try {
            findElement(elementLocator);
            Waits.waitForElementToBeClickable(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).click();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void type(By elementLocator, String text) {
        try {
            findElement(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).sendKeys(text);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
    
    public static String getText(By elementLocator) {
        try {
            findElement(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElement(elementLocator).getText();
    }
}