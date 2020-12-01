package training.employees;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateEmployeeValidator implements ConstraintValidator<CreateEmployeeValidation, CreateEmployeeCommand> {
    public void initialize(CreateEmployeeValidation constraint) {
    }

    public boolean isValid(CreateEmployeeCommand command, ConstraintValidatorContext context) {
        // Validáció
        //return command.getName().length() == command.getLength();
        return true;
    }
}
