package training.employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloServiceTest {

    @Test
    void testSayHello() {
        // Given
        EmployeesConfig employeesConfig = new EmployeesConfig();
        employeesConfig.setMessage("Hello Spring Boot");
        HelloService helloService = new HelloService(employeesConfig);
        // When
        String message = helloService.sayHello();
        // Then
        assertTrue(message.startsWith("Hello Spring Boot "));
    }
}
