package mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

// creates a test environment by loading a full application context
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SortingControllerWithWebEnvironmentIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenHelloWorldMethodIsCalled_thenReturnSuccessString() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("Hello World!", response.getBody());
    }

    @Test
    void whenSortMethodIsCalled_thenReturnSortedArray() throws Exception {
        List<Integer> input = Arrays.asList(5, 3, 8, 1, 9, 2);
        List<Integer> sorted = Arrays.asList(1, 2, 3, 5, 8, 9);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<List> response = restTemplate.postForEntity("http://localhost:" + port + "/",
                new HttpEntity<>(objectMapper.writeValueAsString(input), headers), List.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(sorted, response.getBody());
    }

}