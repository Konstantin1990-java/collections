package pro.sky.java.course2.collections.EmployeeService;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.collections.Employee;
import pro.sky.java.course2.collections.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.collections.exception.EmployeeNotFoundException;
import pro.sky.java.course2.collections.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= 5) {
            throw new EmployeeStorageIsFullException("В этот список нельзя добавить больше 5 сотрудников");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("вы пытаетесь удалить сотрудника которого нет в списке");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employees;
    }
}
