package training.employees;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeesService {

    private static final List<Employee> employees =
            new ArrayList<>(List.of(new Employee(1L, "John Doe"),
                    new Employee(2L, "Jane Doe")));

    private final ModelMapper modelMapper;

    public List<EmployeeDto> findAll(Optional<String> prefix) {
        java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDto>>() {}.getType();
        return modelMapper.map(employees.stream()
                .filter(e -> prefix.isEmpty() || e.getName().startsWith(prefix.get()))
                .collect(Collectors.toList())
                , targetListType);
    }
}
