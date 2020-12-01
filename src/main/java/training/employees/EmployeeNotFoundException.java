package training.employees;

public class EmployeeNotFoundException extends RuntimeException {

    private long id;

    public EmployeeNotFoundException(long id) {
        super("Employee not found with id" + id);
        this.id = id;
    }
}
