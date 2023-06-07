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

    // Adaugare angajat
    @PostMapping("/addEmployee")
    public employee addEmployee(@RequestBody employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Preluare angajat dupa ID angajat
    @GetMapping("/getEmployeeByID/{id}")
    public employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeByID(id);
    }

    // Preluare angajat dupa nume 
    @GetMapping("/getEmployeeByName/{name}")
    public employee getEmployeeByName(@PathVariable String name) {
        return  employeeService.getEmployeeByName(name);
    }

    // Modificare angajat
    @PutMapping("/updateEmployee")
    public employee updateEmployee(@RequestBody employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Stergere angajat
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeByID(@PathVariable int id) {
        return employeeService.deleteEmployeeByID(id);
    }

    // Preluare lista angajati
    @GetMapping("/getAll")
    public List<employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }
}
