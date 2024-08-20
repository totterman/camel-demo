package fi.smartbass.camel_demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelDemoRouter extends RouteBuilder {

    @Autowired
    CamelDemoBean camelBean;

    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{interval}}")
                .routeId("hello")
                .bean(camelBean, "sayHello")
                .to("stream:out");
    }
}
