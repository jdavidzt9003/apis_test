package co.com.lulo.stepdefinition.delete;

import co.com.lulo.exception.FailedCodeStatus;
import co.com.lulo.model.deleteemployee.DeleteEmployee;
import co.com.lulo.question.DeleteSuccessEmployee;
import co.com.lulo.question.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;

import static co.com.lulo.task.DoDelete.doDelete;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteEmployeeStepDefinition {

    private static final String BASE_URL = "https://dummy.restapiexample.com/public/api/v1";
    private static final String PATH = "/delete/2";
    private Actor actor;
    private final HashMap<String, Object> headers = new HashMap<>();

    @Given("que se requiere eliminar un empleado registrado")
    public void queSeRequiereEliminarUnEmpleadoRegistrado() {
        actor = Actor.named("David Zaraza");
        actor.can(CallAnApi.at(BASE_URL));
        headers.put("Content-Type", "text/html; charset=UTF-8");

    }

    @When("elimina el registro de un empleado por id")
    public void eliminaElRegistroDeUnEmpleadoPorId() {
        actor.attemptsTo(
                doDelete().
                        resource(PATH)
                        .withHeaders(headers)
        );
    }

    @Then("la eliminación será exitosa")
    public void laEliminacionSeraExitosa() {
        actor.should(
                seeThat("El código de respuesta fue: ", StatusCode.was(), equalTo(200))
                        .orComplainWith(
                                FailedCodeStatus.class,
                                FailedCodeStatus.THE_RESPONSE_FAILED
                        )
        );
    }
}
