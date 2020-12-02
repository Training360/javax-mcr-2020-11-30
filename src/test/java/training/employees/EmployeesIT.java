package training.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
        //(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(statements = "delete from employees")
//@Sql(scripts = "classpath:/sql/init.sql")
public class EmployeesIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @BeforeEach
//    void init() {
//        jdbcTemplate.update("delete from employees");
//    }

    @Test
//    @RepeatedTest(2)
    @DisplayName("TC-1030 - Save two employees than list them")
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

        int numberOfEmployees =
                jdbcTemplate.queryForObject("select count(id) as c from employees",
                        new RowMapper<Integer>() {
                            @Override
                            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                                return resultSet.getInt("c");
                            }
                        });

        assertEquals(2, numberOfEmployees);
    }
}
