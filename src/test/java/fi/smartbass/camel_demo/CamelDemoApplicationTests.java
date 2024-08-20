package fi.smartbass.camel_demo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.EnableRouteCoverage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@CamelSpringBootTest
@SpringBootTest(classes = CamelDemoApplication.class)
@EnableRouteCoverage
public class CamelDemoApplicationTests {

	@Autowired
	private CamelContext camelContext;

	@Test
	public void shouldProduceMessages() throws Exception {
		NotifyBuilder notifyBuilder = new NotifyBuilder(camelContext)
				.whenDone(1)
				.create();
		assertTrue(notifyBuilder.matches(10L, TimeUnit.SECONDS));
	}

}
