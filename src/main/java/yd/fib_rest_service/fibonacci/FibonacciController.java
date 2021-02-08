package yd.fib_rest_service.fibonacci;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FibonacciController {

    @GetMapping("/fibonacci/{n}")
    public String getFibonacciNumber(@PathVariable Long n) {
        if (n < 0)
            throw new NegativeFibException();
        return FibonacciService.genFib(n);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {NegativeFibException.class })
    public String negativeFibException() {
        return "In the path fibonacci/{n}, n must be greater than zero.";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {TypeMismatchException.class})
    public String TypeMismatchException() {
        return "In the path fibonacci/{n}, n must be a number of type int/long between 0 and 9,223,372,036,854,775,807";
    }


}
