package kg.fibonacci.fibonacciproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciResponse {
    private int requestedNumber;
    private int numberOnSequence;
    private float timeByRecursion;
    private float timeBySecondWay;
}
