package employeeManager.app.repository;


import employeeManager.app.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<employee,Integer> {
    employee getByName(String name);

    employee findByName(String name);
}
