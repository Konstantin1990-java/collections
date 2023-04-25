package pro.sky.java.course2.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.collections.Employee;
import pro.sky.java.course2.collections.EmployeeService.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return new Employee(firstName, lastName);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(String firstName, String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return new Employee(firstName, lastName);
    }

    @GetMapping("/contains")
    public Employee containsEmployee(String firstName, String lastName) {
        employeeService.containsEmployee(firstName, lastName);
        return new Employee(firstName, lastName);
    }

    @GetMapping("/print")
    public EmployeeService printEmployee() {
        return employeeService;
    }
}
