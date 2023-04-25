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

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(String firstName, String lastName) {
        if (employees.size() >= 5) {
            throw new EmployeeStorageIsFullException("В этот список нельзя добавить больше 5 сотрудников");
        }
        if (employees.contains(new Employee(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.add(new Employee(firstName, lastName));
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (!employees.contains(new Employee(firstName, lastName))) {
            throw new EmployeeNotFoundException("вы пытаетесь удалить сотрудника которого нет в списке");
        }
        employees.remove(new Employee(firstName, lastName));

    }

    @Override
    public void containsEmployee(String firstName, String lastName) {
        if (employees.contains(new Employee(firstName, lastName))) {
            System.out.println("В нашем списке имеется сотрудник " + firstName + " " + lastName);
        } else {
            throw new EmployeeNotFoundException("Сотрудника нет в списке");
        }
    }
}
