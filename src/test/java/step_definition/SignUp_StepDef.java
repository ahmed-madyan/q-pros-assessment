package step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.SignUp;
import utilities.reader_manager.json_reader.JSONReaderManager;

import java.util.Random;

public class SignUp_StepDef {
    private static final String test_Data_File_Path = ("src/test/resources/test_data/input/TestData.json");
    private static final JSONObject test_Data = JSONReaderManager.parseJSON(test_Data_File_Path);

    @When("Username sign up with new user data")
    public void usernameSignUpWithNewUserData() {
        Random random = new Random();
        String username = ("username" + random.nextInt());
        SignUp.signUp(username, test_Data.get("password").toString());
    }

    @Then("Validate sign up successful message appears in JS alert")
    public void validateSignUpSuccessfulMessageAppearsInJSAlert() {
        SignUp.validateSignUpSuccessfulMessageInConfirmationAlert(test_Data.get("signUpConfirmationText").toString());
    }

    @And("Accept the confirmation alert")
    public void acceptTheConfirmationAlert() {
        SignUp.acceptSignUpConfirmAlert();
    }
}