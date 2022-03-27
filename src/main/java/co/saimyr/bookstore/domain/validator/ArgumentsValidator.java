package co.saimyr.bookstore.domain.validator;

import co.saimyr.bookstore.domain.exception.BookNotFoundException;
import co.saimyr.bookstore.domain.exception.InvalidValueException;

import java.util.List;

public class ArgumentsValidator {

    public static void validateNotNullOrEmpty(String value, String message){
        if(value==null||value.isBlank()){
            throw new InvalidValueException(message);
        }
    }

    public static <T> void validateListNotEmpty(List<T> list, String message){
        if(list.isEmpty()) {
            throw new BookNotFoundException(message);
        }
    }

    public static void validateNotNull(Object value,String message){
        if(value==null){
            throw new BookNotFoundException(message);
        }
    }

}
