package co.com.lulo.stepdefinition.get;

import co.com.lulo.model.employee.Data;
import co.com.lulo.model.employee.Employee;
import co.com.lulo.question.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import java.util.HashMap;

import static co.com.lulo.task.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


public class GetEmployeeStepDefinition {
    private static final String BASE_URL = "https://dummy.restapiexample.com/public/api/v1";
    private static final String PATH = "/employee/1";
    private Actor actor;
    private final HashMap<String, Object> headers = new HashMap<>();

    @Given("que cargo la información del empleado")
    public void queCargoLaInformaciónDelEmpleado() {
        actor = Actor.named("David Zaraza");
        actor.can(CallAnApi.at(BASE_URL));
        headers.put("Content-Type", "text/HTML");
    }

    @When("llamo la api de consulta")
    public void llamoLaApiDeConsulta() {
        actor.attemptsTo(
                doGet()
                        .resource(PATH)
                        .withHeaders(headers)
        );
    }

    @Then("debería ver los datos del empleado exitosamente")
    public void deberíaVerLosDatosDelEmpleadoExitosamente() {
        Data data = new Data();
        Employee employee = new Employee();

        actor.should(
                seeThat("El código de respuesta fue: ", StatusCode.was(), equalTo(200)),
                seeThat("Usuario existe ", act -> data, notNullValue())
        );
    }
}
