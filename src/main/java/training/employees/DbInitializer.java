package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// @Component
@AllArgsConstructor
public class DbInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("create table employees " +
                "(id bigint auto_increment, emp_name varchar(255), " +
                "primary key (id))");
        jdbcTemplate.execute(
                "insert into employees(emp_name) values ('John Doe')");
        jdbcTemplate.execute(
                "insert into employees(emp_name) values ('Jack Doe')");
    }
}
