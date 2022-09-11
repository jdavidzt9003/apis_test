package co.com.lulo.stepdefinition.get;

import co.com.lulo.exception.DataNull;
import co.com.lulo.exception.FailedCodeStatus;
import co.com.lulo.model.employees.Datum;
import co.com.lulo.question.GetEmployees;
import co.com.lulo.question.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;
import java.util.List;

import static co.com.lulo.task.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetEmployeesStepDefinition {

    private static final String BASE_URL = "https://dummy.restapiexample.com/public/api/v1";
    private static final String PATH = "/employees";
    private Actor actor;
    private final HashMap<String, Object> headers = new HashMap<>();

    @Given("que se carga la información de todos los empleados")
    public void queSeCargaLaInformacionDeTodosLosEmpleados() {
        actor = Actor.named("David Zaraza");
        actor.can(CallAnApi.at(BASE_URL));
        headers.put("Content-Type", "text/HTML");
    }

    @When("se consulta el registro de todos los empleados")
    public void seConsultaElRegistroDeTodosLosEmpleados() {
        actor.attemptsTo(
                doGet()
                        .resource(PATH)
                        .withHeaders(headers)
        );
    }

    @Then("deberá ver los datos de los empleados registrados")
    public void deberaVerLosDatosDeLosEmpleadosRegistrados() {
        Datum employees = new GetEmployees().answeredBy(actor).getData()
                .stream()
                .filter(x -> x.getId() == 1).findFirst().orElse(null);

        actor.should(
                seeThat("El código de respuesta fue: ", StatusCode.was(), equalTo(200))
                        .orComplainWith(
                                FailedCodeStatus.class,
                                FailedCodeStatus.THE_RESPONSE_FAILED
                        ));

        actor.should(
                seeThat("Empleados encontrados", act -> employees, notNullValue())
                        .orComplainWith(
                                DataNull.class,
                                DataNull.DATA_NULL
                        )
        );

        actor.should(
                seeThat("Nombre del usuario", act -> employees.getEmployeeName(), equalTo("Tiger Nixon"))
        );
    }
}
