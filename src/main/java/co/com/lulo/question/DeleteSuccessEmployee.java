package co.com.lulo.question;

import co.com.lulo.model.deleteemployee.DeleteEmployee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DeleteSuccessEmployee implements Question {
    @Override
    public DeleteEmployee answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(DeleteEmployee.class);
    }

    public static DeleteSuccessEmployee deleteSuccessEmployee(){
        return new DeleteSuccessEmployee();
    }
}
