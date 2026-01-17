public class Factorial {
    public static int recursiveFactorial(int n) {
        return (n == 1) ? 1 : n * recursiveFactorial(n - 1);
    }

    public static int iterativeFactorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial of " + number + " is " + iterativeFactorial(number));
    }
}
