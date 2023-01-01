package test_runner;

import io.cucumber.testng.CucumberOptions;
import utilities.hooks.Hooks;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/feature"},
                glue = {"step_definition"},
                tags = ("@E2E")
        )

public class TestRunnerFE extends Hooks {
}