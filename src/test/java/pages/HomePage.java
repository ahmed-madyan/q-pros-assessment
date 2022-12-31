package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.actions.ElementActions;

import java.util.List;

public class HomePage {

    private static final By page_HeaderTitle = By.id("nava");
    private static final By homeTap = By.linkText("Home");
    private static final By contactTap = By.linkText("Home");
    private static final By aboutUsTap = By.linkText("Home");
    private static final By cartTap = By.linkText("Home");
    private static final By logInTap = By.linkText("Log in");
    private static final By signUpTap = By.linkText("Sign up");
    private static final By category_Phones = By.xpath("/descendant::div[@class=\"list-group\"]//a[contains(text(), \"Phones\")]");
    private static final By category_Laptops = By.xpath("/descendant::div[@class=\"list-group\"]//a[contains(text(), \"Laptops\")]");
    private static final By category_Monitors = By.xpath("/descendant::div[@class=\"list-group\"]//a[contains(text(), \"Monitors\")]");
    private static final By card_block = By.className("card-block");

    public static void openHomeTap() {
        ElementActions.click(homeTap);
    }

    public static void openContactTap() {
        ElementActions.click(contactTap);
    }

    public static void openAboutUsTap() {
        ElementActions.click(aboutUsTap);
    }

    public static void openCartTap() {
        ElementActions.click(cartTap);
    }

    public static void openLogInTap() {
        ElementActions.click(logInTap);
    }

    public static void openSignUpTap() {
        ElementActions.click(signUpTap);
    }

    public static void openPhonesCategory() {
        ElementActions.click(category_Phones);
    }

    public static void openLaptopsCategory() {
        ElementActions.click(category_Laptops);
    }

    public static void openMonitorsCategory() {
        ElementActions.click(category_Monitors);
    }

    public static void validateHomePageHeaderText(String expectedText) {
        Assert.assertEquals(ElementActions.getText(page_HeaderTitle), expectedText);
    }

    public static List<WebElement> getListOfCards() {
        return ElementActions.findElements(card_block);
    }

    public static int getNoOfCards() {
        return ElementActions.findElements(card_block).size();
    }

    public static void validateCategoryHasItems() {
        Assert.assertFalse(getListOfCards().isEmpty());
    }
}
