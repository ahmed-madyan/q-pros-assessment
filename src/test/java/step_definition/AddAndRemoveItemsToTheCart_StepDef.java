package step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.Cart;
import pages.HomePage;
import pages.Product;
import utilities.reader_manager.json_reader.JSONReaderManager;

public class AddAndRemoveItemsToTheCart_StepDef {
    private static final String expected_TestData_FilePath = ("src/test/resources/test_data/expected/Expected_TestData.json");
    private static final JSONObject expected_TestData = JSONReaderManager.parseJSON(expected_TestData_FilePath);

    @When("Select phone product")
    public void selectPhoneProduct() {
        HomePage.selectRandomPhone();
    }

    @Then("Validate user navigated to the product page")
    public void validateUserNavigatedToTheProductPage() {
        Product.validateUserNavigatedToProductsPage();
    }

    @When("Phone added to the cart")
    public void phoneAddedToTheCart() {
        Product.addToCart();
    }

    @Then("Alert pop up should be displayed with a success message")
    public void alertPopUpShouldBeDisplayedWithASuccessMessage() {
        Product.validateProductAddedMessageInConfirmationAlert(expected_TestData.get("productAddedConfirmationText").toString());
    }

    @When("User accepts the alert pop")
    public void userAcceptsTheAlertPop() {
        Product.acceptProductAddedConfirmAlert();
    }

    @Then("Validate that phone exists in the cart")
    public void validateThatPhoneExistsInTheCart() {
        Cart.validateCartIsNotEmpty();
    }

    @When("Remove the product")
    public void removeTheProduct() {
        Cart.deleteRandomItem();
    }

    @Then("Cart Should be Empty")
    public void cartShouldBeEmpty() {
        Cart.validateCartIsEmpty();
    }

    @And("User navigated to the cart")
    public void userNavigatedToTheCart() {
        HomePage.openCartTap();
    }
}