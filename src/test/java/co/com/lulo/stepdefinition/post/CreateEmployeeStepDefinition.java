package co.com.lulo.stepdefinition.post;

import co.com.lulo.question.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

import static co.com.lulo.task.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateEmployeeStepDefinition {

    private static final String BASE_URL = "https://dummy.restapiexample.com/public/api/v1";
        private static final String PATH = "/create";
        private Actor actor;
    private final HashMap<String, Object> headers = new HashMap<>();

    @Given("se quiere registrar un empleado")
    public void seQuiereRegistrarUnEmpleado() {

        actor = Actor.named("David Zaraza");
        actor.can(CallAnApi.at(BASE_URL));
        headers.put("Content-Type", "text/xml;charset=UTF-8");

    }
    @When("se envia la información del empleado")
    public void seEnviaLaInformaciónDelEmpleado() {
        actor.attemptsTo(
                doPost()
                        .resource(PATH)
                        .withHeaders(headers)
        );
    }
    @Then("se deberá registrar exitosamente")
    public void seDeberáRegistrarExitosamente() {
        actor.should(
                seeThat("El código de respuesta fue: ", StatusCode.was(), equalTo(200))
        );
    }
}
