package kg.fibonacci.fibonacciproject.controllers;

import kg.fibonacci.fibonacciproject.models.FibonacciResponse;
import kg.fibonacci.fibonacciproject.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fibonacci")
public class FibonacciController {

    @Autowired
    FibonacciService fibonacciService;

    @GetMapping("/{number}")
    public FibonacciResponse getNumberOnSequence(@PathVariable int number) {
        return fibonacciService.getNumberOnSequence(number);
    }
}
