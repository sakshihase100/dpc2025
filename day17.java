import java.util.*;

class PrimeFactorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();  
        List<Long> factors = primeFactors(n);
        System.out.println(factors);
        sc.close();
    }

    public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }

        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n is still > 1, it must be prime
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }
}
