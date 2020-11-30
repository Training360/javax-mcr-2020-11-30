package training.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {

    @Mock
    HelloService helloService;

    @InjectMocks
    HelloController helloController;

    @Test
    void testSayHello() {
        // Given
        when(helloService.sayHello()).thenReturn("hello");

        // When
        String message = helloController.sayHello();

        // Then
        assertEquals("HELLO", message);

        verify(helloService, times(1)).sayHello();
    }

    @Test
    void testSayHelloWithNull() {
        when(helloService.sayHello()).thenReturn(null);

        // When
        String message = helloController.sayHello();

        assertEquals("", message);
    }
}
