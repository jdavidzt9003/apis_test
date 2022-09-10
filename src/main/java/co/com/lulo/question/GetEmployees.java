package co.com.lulo.question;

import co.com.lulo.model.employees.Employees;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetEmployees implements Question {

    @Override
        public Employees answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Employees.class);
    }

    public static GetEmployees getEmployees(){
        return new GetEmployees();
    }
}
