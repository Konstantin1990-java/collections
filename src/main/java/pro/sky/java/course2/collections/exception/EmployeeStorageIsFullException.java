package pro.sky.java.course2.collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//непроверяемое исключение которое выбрасывается, если коллекция сотрудников переполнена
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException(String message) {
            super(message);
        }
    }
