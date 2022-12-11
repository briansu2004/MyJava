import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class FutureForkJoinRun {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

        forkJoinPool.execute(calculator);

        Integer result1 = calculator.get();

        System.out.println(result1);
    }
}
