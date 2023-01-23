import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        long tInit = System.nanoTime();
        int num = 30000;
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 1; i <= num; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println("The factorial of " + num + " is: " + factorial);
        System.out.println(System.nanoTime() - tInit);
    }
}
