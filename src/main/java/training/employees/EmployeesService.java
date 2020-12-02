package training.employees;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeesService {

    private EmployeesRepository employeesRepository;

    private final ModelMapper modelMapper;

    public List<EmployeeDto> findAll(Optional<String> prefix) {
        java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDto>>() {}.getType();
        return modelMapper.map(employeesRepository.findAll()
                , targetListType);
    }

    public EmployeeDto findById(long id) {
        return modelMapper.map(employeesRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id))
                , EmployeeDto.class);
    }

    public EmployeeDto create(CreateEmployeeCommand command) {
        log.info("Create employee");
        log.debug("Create employee with name" + command.getName());
        Employee employee = new Employee(command.getName());
        employeesRepository.save(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Transactional
    public EmployeeDto update(long id, UpdateEmployeeCommand command) {
        Employee employee = employeesRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employee.setName(command.getName());

        return modelMapper.map(employee, EmployeeDto.class);
    }

    public void delete(long id) {
        employeesRepository.deleteById(id);
    }

    public void clear() {

        // TODO Teszthez kell?

    }
}
