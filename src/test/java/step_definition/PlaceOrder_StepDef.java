package step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.Cart;
import pages.HomePage;
import pages.PlaceOrder;
import pages.Product;
import utilities.reader_manager.json_reader.JSONReaderManager;

public class PlaceOrder_StepDef {
    private static final String expected_TestData_FilePath = ("src/test/resources/test_data/expected/Expected_TestData.json");
    private static final JSONObject expected_TestData = JSONReaderManager.parseJSON(expected_TestData_FilePath);

    @And("Place order")
    public void placeOrder() {
        Cart.placeOrder();
    }

    @And("Complete purchase")
    public void completePurchase() {
        PlaceOrder.typePurchaseData(
                expected_TestData.get("purchase_Name").toString(), expected_TestData.get("purchase_Country").toString(),
                expected_TestData.get("purchase_City").toString(), expected_TestData.get("purchase_Card").toString(),
                expected_TestData.get("purchase_Month").toString(), expected_TestData.get("purchase_Year").toString());
        PlaceOrder.completePurchase();
    }

    @Then("Validate purchase success message")
    public void validatePurchaseSuccessMessage() {
        PlaceOrder.validateSuccessfulPurchase(expected_TestData.get("purchase_Success_Message").toString());
        PlaceOrder.acceptSuccessfulPurchaseMessage();
    }
}