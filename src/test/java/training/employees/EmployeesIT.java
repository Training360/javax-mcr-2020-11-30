package training.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
        //(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeesIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmployeesService employeesService;

    @BeforeEach
    void clear() {
        employeesService.clear();
    }

//    @Test
    @RepeatedTest(2)
    void testSaveAndFindAll() throws Exception {
        mockMvc.perform(
                post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John Doe\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(
                post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Jack Doe\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/api/employees"))
                 .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()", equalTo(2)))
                .andExpect(jsonPath("[1].name", equalTo("Jack Doe")));
    }
}
