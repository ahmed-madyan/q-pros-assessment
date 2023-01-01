package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.testng.Assert;
import pages.HomePage;
import utilities.driver_manager.DriverManager;
import utilities.reader_manager.json_reader.JSONReaderManager;

import java.util.Objects;

public class HomePage_StepDef {
    private static final String test_Data_File_Path = ("src/test/resources/test_data/expected/Expected_TestData.json");
    private static final JSONObject test_Data = JSONReaderManager.parseJSON(test_Data_File_Path);

    @Given("User navigated to the portal url")
    public void userNavigatedToThePortalUrl() {
        HomePage.validateHomePageHeaderText(test_Data.get("homePageHeader_Text").toString());
    }

    @When("User navigated to home tap")
    public void userNavigatedToHomeTap() {
        HomePage.openHomeTap();
    }
}