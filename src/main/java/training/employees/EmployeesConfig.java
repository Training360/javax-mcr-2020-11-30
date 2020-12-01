package training.employees;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "employees.welcome")
@Data
@Validated
public class EmployeesConfig {

    @NotBlank
    private String message;
}
