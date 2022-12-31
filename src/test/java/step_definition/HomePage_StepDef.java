package step_definition;

import io.cucumber.java.en.Given;
import org.json.simple.JSONObject;
import org.testng.Assert;
import utilities.driver_manager.DriverManager;
import utilities.reader_manager.json_reader.JSONReaderManager;

public class HomePage_StepDef {
    private static final String test_Data_File_Path = ("src/test/resources/test_data/expected/Expected_TestData.json");
    private static final JSONObject test_Data = JSONReaderManager.parseJSON(test_Data_File_Path);

    @Given("User navigated to the portal url")
    public void userNavigatesToThePortalUrl() {
        Assert.assertEquals(test_Data.get("portal_URL"), DriverManager.getDriver().getCurrentUrl());
    }

}