package pro.sky.java.course2.collections.EmployeeService;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.collections.Employee;
import pro.sky.java.course2.collections.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.collections.exception.EmployeeNotFoundException;
import pro.sky.java.course2.collections.exception.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= 5) {
            throw new EmployeeStorageIsFullException("В этот список нельзя добавить больше 5 сотрудников");
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("вы пытаетесь удалить сотрудника которого нет в списке");
        }
        employees.remove(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }
    }

    @Override
    public Collection<Employee> findAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
