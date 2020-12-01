package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;

    @GetMapping
    public List<EmployeeDto> findAll(@RequestParam Optional<String> prefix) {
        return employeesService.findAll(prefix);
    }
}
