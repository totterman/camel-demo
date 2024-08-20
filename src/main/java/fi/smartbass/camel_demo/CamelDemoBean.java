package fi.smartbass.camel_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("camelBean")
public class CamelDemoBean {
    private int counter;

    @Value("${message}")
    private String msg;

    public String sayHello(String body) {
        return String.format("%s is called %d times", msg, ++counter);
    }
}
