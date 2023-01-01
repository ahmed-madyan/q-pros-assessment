package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.testng.Assert;
import pages.HomePage;
import utilities.driver_manager.DriverManager;
import utilities.reader_manager.json_reader.JSONReaderManager;

import java.util.Objects;

public class CheckListedCategoriesHasItems_StepDef {
    private static final String expected_TestData_FilePath = ("src/test/resources/test_data/expected/Expected_TestData.json");
    private static final JSONObject expected_TestData = JSONReaderManager.parseJSON(expected_TestData_FilePath);
    private static final String input_TestData_FilePath = ("src/test/resources/test_data/input/Input_TestData.json");
    private static final JSONObject input_TestData = JSONReaderManager.parseJSON(input_TestData_FilePath);

    @When("Navigated to phones category")
    public void navigatedToPhonesCategory() {
        HomePage.openPhonesCategory();
    }

    @Then("Validate that phones category has items")
    public void validateThatPhonesCategoryHasItems() {
        HomePage.validateCategoryHasItems();
    }

    @When("Navigated to laptops category")
    public void navigatedToLaptopsCategory() {
        HomePage.openLaptopsCategory();
    }

    @Then("Validate that laptops category has items")
    public void validateThatLaptopsCategoryHasItems() {
        HomePage.validateCategoryHasItems();
    }

    @When("Navigated to monitors category")
    public void navigatedToMonitorsCategory() {
        HomePage.openMonitorsCategory();
    }

    @Then("Validate that monitors category has items")
    public void validateThatMonitorsCategoryHasItems() {
        HomePage.validateCategoryHasItems();
    }
}