package kg.fibonacci.fibonacciproject.services.impl;

import kg.fibonacci.fibonacciproject.models.Fibonacci;
import kg.fibonacci.fibonacciproject.models.FibonacciResponse;
import kg.fibonacci.fibonacciproject.services.FibonacciService;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public FibonacciResponse getNumberOnSequence(int number) {
        if ((number - 1) < 0) {
            return getNumberOnSequence(1);
        } else {
            int numberSequence = number - 1;
            Fibonacci fibonacciResponseOne = new Fibonacci();
            Fibonacci fibonacciResponseTwo = new Fibonacci();

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            fibonacciResponseOne.setNumber(fibonacciByRecursion(numberSequence));
            stopWatch.stop();
            fibonacciResponseOne.setTimeSpent(stopWatch.getLastTaskTimeMillis());

            stopWatch.start();
            fibonacciResponseTwo.setNumber(fibonacciBySecondWay(numberSequence));
            stopWatch.stop();
            fibonacciResponseTwo.setTimeSpent(stopWatch.getLastTaskTimeMillis());

            return new FibonacciResponse(number, fibonacciResponseOne.getNumber(), fibonacciResponseOne.getTimeSpent(), fibonacciResponseTwo.getTimeSpent());
        }
    }

    private int fibonacciByRecursion(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1 || number == 2) {
            return 1;
        }

        return fibonacciByRecursion(number - 1) + fibonacciByRecursion(number - 2);
    }

    private int fibonacciBySecondWay(int number) {
        Map<Integer, Integer> cacheTable = new HashMap<>();
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        if (cacheTable.containsKey(number)) {
            return cacheTable.get(number);
        }

        int result = fibonacciBySecondWay(number - 1) + fibonacciBySecondWay(number - 2);
        cacheTable.put(number, result);
        return result;
    }
}
