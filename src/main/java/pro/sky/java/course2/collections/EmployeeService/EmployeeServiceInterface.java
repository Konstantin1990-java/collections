package pro.sky.java.course2.collections.EmployeeService;

public interface EmployeeServiceInterface {
    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    void containsEmployee(String firstName, String lastName);
}
