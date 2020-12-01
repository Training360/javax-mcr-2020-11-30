package training.employees;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CdvValidator implements ConstraintValidator<CdvValidation, String> {
    public void initialize(CdvValidation constraint) {
    }

    public boolean isValid(String s, ConstraintValidatorContext context) {
        return checkCDV(s);
    }


    public boolean checkCDV(String code) {
        String multipliers = "9731";
        int i = 0;
        int sum = 0;
        for (i=0; i<code.length()-1; i++){
            sum += Character.digit(code.charAt(i),10)
                    * Character.digit(multipliers.charAt((i % 4)),10);
        }
        System.out.println((10-(sum % 10)));
        return (10-(sum % 10)) == Character.digit(code.charAt(code.length()-1),10);
    }

}
