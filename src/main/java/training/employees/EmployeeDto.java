package training.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    private String name;

    private AddressDto addressDto;

    public EmployeeDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
