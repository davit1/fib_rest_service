package yd.fib_rest_service;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FibonacciController {

    @Autowired
    FibonacciService fibonacciService;

    @GetMapping("/fibonacci/{number}")
    public String getFibonacciNumber(@PathVariable Long number) {
        if (number < 0)
            throw new IllegalArgumentException();
        return fibonacciService.genFib(number);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {IllegalArgumentException.class, TypeMismatchException.class})
    public void illegalArgumentException() {}


}
