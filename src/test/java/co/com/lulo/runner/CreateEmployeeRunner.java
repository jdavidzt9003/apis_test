package co.com.lulo.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/post/createemployee.feature"},
        glue = {"co.com.lulo.stepdefinition.post"}
)
public class CreateEmployeeRunner {
}
