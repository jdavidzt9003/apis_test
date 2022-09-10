package co.com.lulo.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/getemployees.feature"},
        glue = {"co.com.sofka.stepdefinition"}
)
public class GetEmployeesRunner {
}
