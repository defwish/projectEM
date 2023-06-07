package employeeManager.app.controller;

import employeeManager.app.model.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emp")
public class employeeController {

    @Autowired
    private employeeManager.app.services.employeeService employeeService;

    // Add new employee
    @PostMapping("/addEmployee")
    public employee addEmployee(@RequestBody employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Add more than 1 employee
    @PostMapping("/addEmployees")
    public List<employee> addAllEmployees(@RequestBody List<employee> employees) {
        return employeeService.addAllEmployees(employees);
    }

    // Get employee by Id
    @GetMapping("/getEmployeeByID/{id}")
    public employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeByID(id);
    }

    // Get employee by name
    @GetMapping("/getEmployeeByName/{name}")
    public employee getEmployeeByName(@PathVariable String name) {
        return  employeeService.getEmployeeByName(name);
    }

    // Update employee
    @PutMapping("/updateEmployee")
    public employee updateEmployee(@RequestBody employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeByID(@PathVariable int id) {
        return employeeService.deleteEmployeeByID(id);
    }

    // Get all employees
    @GetMapping("/getAll")
    public List<employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }
}
