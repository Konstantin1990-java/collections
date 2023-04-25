package pro.sky.java.course2.collections.EmployeeService;

import pro.sky.java.course2.collections.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> findAllEmployees();
}
