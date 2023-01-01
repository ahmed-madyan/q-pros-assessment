package step_definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.Login;
import utilities.reader_manager.json_reader.JSONReaderManager;

public class LogIn_StepDef {
    private static final String input_TestData_FilePath = ("src/test/resources/test_data/input/Input_TestData.json");
    private static final JSONObject input_TestData = JSONReaderManager.parseJSON(input_TestData_FilePath);

    @When("Login with existing user")
    public void loginWithExistingUser() {
        Login.login(input_TestData.get("userName").toString(), input_TestData.get("password").toString());
    }

    @Then("Validate user logged in successfully")
    public void validateUserLoggedInSuccessfully() {
    }

    @When("Login with the new generated username")
    public void loginWithTheNewGeneratedUsername() {
        Login.login(SignUp_StepDef.getUsername(), input_TestData.get("password").toString());
    }
}
