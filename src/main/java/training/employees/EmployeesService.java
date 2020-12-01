package training.employees;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeesService {

    private static final AtomicLong idGenerator = new AtomicLong();

    private static final List<Employee> employees =
            new ArrayList<>(List.of(new Employee(idGenerator.incrementAndGet(), "John Doe"),
                    new Employee(idGenerator.incrementAndGet(), "Jane Doe")));

    private final ModelMapper modelMapper;

    public List<EmployeeDto> findAll(Optional<String> prefix) {
        java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDto>>() {}.getType();
        return modelMapper.map(employees.stream()
                .filter(e -> prefix.isEmpty() || e.getName().startsWith(prefix.get()))
                .collect(Collectors.toList())
                , targetListType);
    }

    public EmployeeDto findById(long id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .map(e -> modelMapper.map(e, EmployeeDto.class))
                .findAny().orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public EmployeeDto create(CreateEmployeeCommand command) {
        Employee employee = new Employee(idGenerator.incrementAndGet(), command.getName());
        employees.add(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public EmployeeDto update(long id, UpdateEmployeeCommand command) {
        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findAny().orElseThrow(() -> new EmployeeNotFoundException(id));
        employee.setName(command.getName());
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public void delete(long id) {
        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findAny().orElseThrow(() -> new EmployeeNotFoundException(id));
        employees.remove(employee);
    }
}
