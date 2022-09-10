package co.com.lulo.question;

import co.com.lulo.model.employee.Employee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class GetSuccessEmployee implements Question {

    @Override
    public Employee answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Employee.class);
    }

    public static GetSuccessEmployee getEmployee(){
        return new GetSuccessEmployee();
    }
}
