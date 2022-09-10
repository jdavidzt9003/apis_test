package co.com.lulo.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/get/getemployees.feature"},
        glue = {"co.com.lulo.stepdefinition.get"}
)
public class GetEmployeesRunner {
}
