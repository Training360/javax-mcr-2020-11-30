package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable long id) {
        return employeesService.findById(id);
    }

    @PostMapping
    public EmployeeDto create(@RequestBody CreateEmployeeCommand command) {
        return employeesService.create(command);
    }

    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable long id, @RequestBody UpdateEmployeeCommand command) {
        return employeesService.update(id, command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        employeesService.delete(id);
    }
}