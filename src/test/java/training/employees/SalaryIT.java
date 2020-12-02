package training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.jdbc.Sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql(statements = "delete from salary")
public class SalaryIT {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void testGetSalarySum() {
        jdbcTemplate.update("insert into salary(amount) values (100)");
        jdbcTemplate.update("insert into salary(amount) values (200)");

        long sum = jdbcTemplate.queryForObject("call GetSalarySum()",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getLong(1);
                    }
                });

        assertEquals(300, sum);
    }
}
