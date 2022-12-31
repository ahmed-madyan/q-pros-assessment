package utilities.actions;

import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.waits.Waits;

import java.util.Objects;

public class AlertActions {

    public static void acceptAlert() {
        try {
            Waits.waitForAlertToBeVisible();
            Objects.requireNonNull(DriverManager.getDriver()).switchTo().alert().accept();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static String getAlertText() {
        try {
            Waits.waitForAlertToBeVisible();
            return Objects.requireNonNull(DriverManager.getDriver()).switchTo().alert().getText();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
            return null;
        }
    }
}