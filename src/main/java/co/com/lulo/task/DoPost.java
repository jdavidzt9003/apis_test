package co.com.lulo.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;

public class DoPost implements Task {
    private String resource;
    private HashMap<String, Object> headers = new HashMap<>();

    public DoPost resource(String resource) {
        this.resource = resource;
        return this;
    }

    public DoPost withHeaders(HashMap<String, Object> headers) {
        this.headers = headers;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(
                                requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                        .headers(headers)
                )
        );
    }

    public static DoPost doPost() {
        return new DoPost();
    }
}
