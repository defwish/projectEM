package employeeManager.app.services;

import employeeManager.app.model.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {

    @Autowired
    private employeeManager.app.repository.employeeRepository employeeRepository;

    public employee addEmployee(employee employee) {
        return employeeRepository.save(employee);
    }

    public List<employee> addAllEmployees(List<employee> employees) {
        return  employeeRepository.saveAll(employees);
    }

    public employee getEmployeeByID(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public employee getEmployeeByName(String name) {
        return  employeeRepository.findByName(name);
    }

    public employee updateEmployee(employee employee) {
        employeeManager.app.model.employee existingEMP = employeeRepository.findById(employee.getId()).orElse(null);
        System.out.println(employee);
        if(existingEMP == null) {
            System.out.println("Emp not found");
            return  employeeRepository.save(employee);
        }else  {
            existingEMP.setName(employee.getName());
            existingEMP.setEmail(employee.getEmail());
            existingEMP.setSalary(employee.getSalary());
            employeeRepository.save(existingEMP);
        }
        return employee;
    }

    public boolean deleteEmployeeByID(int id) {
        employee existingEMP = employeeRepository.getById(id);
        if(existingEMP != null) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
