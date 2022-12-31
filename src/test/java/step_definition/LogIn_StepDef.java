package step_definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.Login;
import utilities.reader_manager.json_reader.JSONReaderManager;

public class LogIn_StepDef {
    private static final String test_Data_File_Path = ("src/test/resources/test_data/fe/input/TestData.json");
    private static final JSONObject test_Data = JSONReaderManager.parseJSON(test_Data_File_Path);

    @When("Login with existing user")
    public void loginWithExistingUser() {
        Login.login(test_Data.get("userName").toString(), test_Data.get("password").toString());
    }

    @Then("Validate user logged in successfully")
    public void validateUserLoggedInSuccessfully() {
    }
}
