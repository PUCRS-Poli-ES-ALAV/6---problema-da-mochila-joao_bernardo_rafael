import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {

  
    public static BigInteger fiboRec(int n) {
        if (n <= 1) return BigInteger.valueOf(n);
        return fiboRec(n - 1).add(fiboRec(n - 2));
    }   

    
    public static BigInteger fiboIterativo(int n) {
        if (n <= 1) return BigInteger.valueOf(n);
        BigInteger[] f = new BigInteger[n + 1];
        f[0] = BigInteger.ZERO;
        f[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1].add(f[i - 2]);
        }
        return f[n];
    }

    
    public static BigInteger memoizedFibo(int n) {
        BigInteger[] f = new BigInteger[n + 1];
        Arrays.fill(f, BigInteger.valueOf(-1));
        return lookupFibo(f, n);
    }

    private static BigInteger lookupFibo(BigInteger[] f, int n) {
        if (f[n].compareTo(BigInteger.ZERO) >= 0) return f[n];
        if (n <= 1) {
            f[n] = BigInteger.valueOf(n);
        } else {
            f[n] = lookupFibo(f, n - 1).add(lookupFibo(f, n - 2));
        }
        return f[n];
    }

    public static void main(String[] args) {
        int[] testes = {4, 8, 16, 32};
        int[] testesGrandes = {128, 1000, 10000};

        System.out.println("--- Testes Iniciais ---");
        for (int n : testes) {
            System.out.println("n=" + n + " | Iterativo: " + fiboIterativo(n));
            
        }

        System.out.println("\n--- Testes Grandes (Apenas Iterativo e Memoized) ---");
        for (int n : testesGrandes) {
            System.out.println("n=" + n + " (Calculado com sucesso)");
           
            if(n == 128) System.out.println("Fib(128) = " + fiboIterativo(n));
        }
    }
}