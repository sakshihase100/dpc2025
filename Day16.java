import java.util.Scanner;

public class LCMCalculator {
    // Function to compute GCD using Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to compute LCM
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;  // Avoids overflow
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        System.out.println(lcm(N, M));
        sc.close();
    }
}
