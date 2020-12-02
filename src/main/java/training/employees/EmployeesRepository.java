package training.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    //@Query(nativeQuery = true, "")
//    @Query("select e from Employee e where e.name like :prefix")
    //@Query("select distinct e from Employee e left join fetch e.addresses")
//    List<Employee> findAllByNameIsStartingWith(String prefix);
        // select e from Employee e where e.name like %?
}
