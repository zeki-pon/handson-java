package mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mvc.service.SortingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// designed for MVC-related tests, focusing on the web layer and providing easy testing for specific controllers.
@WebMvcTest(SortingController.class)
class SortingControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SortingService sortingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenHelloWorldMethodIsCalled_thenReturnSuccessString() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void whenSortMethodInCalled_thenReturnSortedArray() throws Exception {
        List<Integer> input = Arrays.asList(5, 3, 8, 1, 9, 2);
        List<Integer> sorted = Arrays.asList(1, 2, 3, 5, 8, 9);

        when(sortingService.sortArray(input)).thenReturn(sorted);

        mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(sorted)));
    }
}