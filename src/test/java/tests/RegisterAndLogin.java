//package tests;
//
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//import pages.HomePage;
//import utilities.actions.ElementActions;
//import utilities.test_base.TestBase;
//
//import java.util.List;
//
//public class RegisterAndLogin extends TestBase {
//
//
//    @Test
//    public static void getPhoneList() throws InterruptedException {
//        HomePage.openPhonesCategory();
//        List<WebElement> phonelist = HomePage.getListOfCards();
//        HomePage.validateCategoryHasItems();
//        for (int i = 0; i < phonelist.size(); i++) {
//            System.out.println(ElementActions.getText(phonelist(i));
//        }
//        HomePage.openLaptopsCategory();
//        List<WebElement> laptopslist = HomePage.getListOfCards();
//        HomePage.validateCategoryHasItems();
//        for (int i = 0; i < laptopslist.size(); i++) {
//            System.out.println(laptopslist.get(i).getText());
//        }
//        HomePage.openMonitorsCategory();
//        List<WebElement> monitorslist = HomePage.getListOfCards();
//        HomePage.validateCategoryHasItems();
//        for (int i = 0; i < monitorslist.size(); i++) {
//            System.out.println(monitorslist.get(i).getText());
//        }
//        System.out.println("No of items in Phones category: \n" + phonelist.size() +
//                "No of items in Laptops category: \n" + laptopslist.size() +
//                "No of items in Monitors category: \n" + monitorslist.size());
//    }
//}