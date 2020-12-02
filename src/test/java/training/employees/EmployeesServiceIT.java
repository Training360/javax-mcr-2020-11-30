package training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@Sql(statements = "delete from employees")
public class EmployeesServiceIT {

    @Autowired
    EmployeesService employeesService;

    @MockBean
    AddressesGateway addressesGateway;

    @Test
    void testSaveThanFindById() {
        when(addressesGateway.getAddress(any())).thenReturn(new AddressDto("Budapest", "Fo u. 1."));

        EmployeeDto employee = employeesService.create(new CreateEmployeeCommand("John Doe"));

        EmployeeDto employeeDto = employeesService.findById(employee.getId());

        assertEquals("John Doe", employeeDto.getName());
        System.out.println(employeeDto.getAddressDto());

    }
}
