package training.employees;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@CreateEmployeeValidation
public class CreateEmployeeCommand {

    @Schema(description="name of the employee", example = "John Doe")

    @NotBlank(message = "name of the employee can not be empty")
    private String name;

//    private int length;

//    @CdvValidation
//    private String adoszam;
}
