package pro.sky.java.course2.collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//непроверяемое исключение которое выбрасывается, когда нового сотрудника пытаются добавить в коллекцию,
    // а в коллекции уже есть такой сотрудник
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException {

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
