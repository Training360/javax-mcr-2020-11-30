package training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql(statements = "delete from employees")
public class EmployeesRepositoryIT {

    @Autowired
    EmployeesRepository employeesRepository;

    @Test
    void testCreateThanList() {
        employeesRepository.save(new Employee("John Doe"));
        employeesRepository.save(new Employee("Jane Doe"));

        List<Employee> employees = employeesRepository.findAll(
                Sort.by("name")
        );
        assertThat(employees)
                .extracting(Employee::getName)
                .containsExactly("Jane Doe", "John Doe");
    }
}
