package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableConfigurationProperties(EmployeesConfig.class)
@AllArgsConstructor
public class HelloService {

    private EmployeesConfig employeesConfig;

    //private String welcome;

    // SPEL = Spring Expression Language
//    public HelloService(@Value("${employees.welcome.message}") String welcome) {
//        this.welcome = welcome;
//    }

    public String sayHello() {
        // Üzleti logika
//        return welcome + " " + LocalDateTime.now();
        return employeesConfig.getMessage() + LocalDateTime.now();
    }
}
