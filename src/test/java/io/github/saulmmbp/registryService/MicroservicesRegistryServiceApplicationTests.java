package io.github.saulmmbp.registryService;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class MicroservicesRegistryServiceApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void catalogLoads() {
	@SuppressWarnings("rawtypes")
	ResponseEntity<Map> entity = testRestTemplate.withBasicAuth("admin", "admin").getForEntity("/eureka/apps", Map.class);

	Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void adminLoads() {
	@SuppressWarnings("rawtypes")
	ResponseEntity<Map> entity = testRestTemplate.withBasicAuth("admin", "admin").getForEntity("/actuator/env", Map.class);
	Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
