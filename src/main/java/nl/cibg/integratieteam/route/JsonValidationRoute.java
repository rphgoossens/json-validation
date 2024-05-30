package nl.cibg.integratieteam.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonValidationRoute extends RouteBuilder {

    @Override
    public void configure() {
        rest()
                .post("/validate").to("direct:validate");

        from("direct:validate")
                .to("json-validator:my-schema.json")
                .to("mock:end");
    }

}

