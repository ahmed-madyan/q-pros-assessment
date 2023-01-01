package step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.SignUp;
import utilities.reader_manager.json_reader.JSONReaderManager;

import java.util.Random;

public class SignUp_StepDef {
    private static final String expected_TestData_FilePath = ("src/test/resources/test_data/expected/Expected_TestData.json");
    private static final JSONObject expected_TestData = JSONReaderManager.parseJSON(expected_TestData_FilePath);
    private static final String input_TestData_FilePath = ("src/test/resources/test_data/input/Input_TestData.json");
    private static final JSONObject input_TestData = JSONReaderManager.parseJSON(input_TestData_FilePath);
    private static String username;

    @When("Username sign up with new generate user data")
    public void usernameSignUpWithNewUserData() {
        Random random = new Random();
        setUsername("username" + random.nextInt(0,10000));
        SignUp.signUp(username, input_TestData.get("password").toString());
    }

    @Then("Validate sign up successful message appears in JS alert")
    public void validateSignUpSuccessfulMessageAppearsInJSAlert() {
        SignUp.validateSignUpSuccessfulMessageInConfirmationAlert(expected_TestData.get("signUpConfirmationText").toString());
    }

    @And("Accept the confirmation alert")
    public void acceptTheConfirmationAlert() {
        SignUp.acceptSignUpConfirmAlert();
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SignUp_StepDef.username = username;
    }
}