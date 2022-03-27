package co.saimyr.bookstore.web.exceptionhandler;

import co.saimyr.bookstore.domain.exception.BookNotFoundException;
import co.saimyr.bookstore.domain.exception.InvalidValueException;
import co.saimyr.bookstore.web.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BookControllerExceptionHandler {
    @ExceptionHandler(value = {BookNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Response notFoundException(BookNotFoundException exception, WebRequest webRequest)
    {
        Response response=new Response();
        response.setMessage(exception.getMessage());
        return response;
    }

    @ExceptionHandler(value = {InvalidValueException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response notValidException(InvalidValueException exception, WebRequest webRequest)
    {
        Response response=new Response();
        response.setMessage(exception.getMessage());
        return response;
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response exception(Exception exception, WebRequest webRequest)
    {
        Response response=new Response();
        response.setMessage(exception.getMessage());
        return response;
    }
}
