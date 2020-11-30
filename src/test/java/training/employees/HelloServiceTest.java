package training.employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloServiceTest {

    @Test
    void testSayHello() {
        // Given
        HelloService helloService = new HelloService();
        // When
        String message = helloService.sayHello();
        // Then
        assertTrue(message.startsWith("Hello Spring Boot "));
    }
}
