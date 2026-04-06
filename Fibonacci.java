import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {
    //calculo de fibonacci usando recursao simples
    public static BigInteger fiboRec(int n) {
        if (n <= 1) return BigInteger.valueOf(n); //caso base
        return fiboRec(n - 1).add(fiboRec(n - 2)); //recursao para n-1 e n-2
    }
    //calculo de fibonacci usando iteracao e vetor de resultados
    public static BigInteger fiboIterativo(int n) {
        if (n <= 1) return BigInteger.valueOf(n); //casos base 0 e 1
        BigInteger[] f = new BigInteger[n + 1]; //vetor para armazenar valores
        f[0] = BigInteger.ZERO;
        f[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1].add(f[i - 2]); //soma dos dois anteriores
        }
        return f[n]; //retorna fibo de n
    }
    //calculo de fibonacci com memoizacao para evitar recalculos
    public static BigInteger memoizedFibo(int n) {
        BigInteger[] f = new BigInteger[n + 1]; //vetor de memoizacao
        Arrays.fill(f, BigInteger.valueOf(-1)); //marca valores desconhecidos
        return lookupFibo(f, n);
    }
    //funcao auxiliar que retorna fibo(n) usando memoizacao
    private static BigInteger lookupFibo(BigInteger[] f, int n) {
        if (f[n].compareTo(BigInteger.ZERO) >= 0) return f[n]; //valor ja calculado
        if (n <= 1) {
            f[n] = BigInteger.valueOf(n); //caso base
        } else {
            f[n] = lookupFibo(f, n - 1).add(lookupFibo(f, n - 2)); //recursao com guardado
        }
        return f[n]; //retorna valor calculado ou recuperado
    }
    //metodo principal que executa os testes de fibonacci
    public static void main(String[] args) {
        int[] testes = {4, 8, 16, 32}; //casos pequenos
        int[] testesGrandes = {128, 1000, 10000}; //casos grandes

        System.out.println("--- Testes Iniciais ---");
        for (int n : testes) {
            System.out.println("n=" + n + " | Iterativo: " + fiboIterativo(n)); //imprime resultado iterativo
        }

        System.out.println("\n--- Testes Grandes (Apenas Iterativo e Memoized) ---");
        for (int n : testesGrandes) {
            System.out.println("n=" + n + " (Calculado com sucesso)"); //confirma calculo
            if (n == 128) System.out.println("Fib(128) = " + fiboIterativo(n)); //imprime exemplo
        }
    }
}