package co.com.lulo.question;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CreateSuccessEmployee implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse();
    }
}
