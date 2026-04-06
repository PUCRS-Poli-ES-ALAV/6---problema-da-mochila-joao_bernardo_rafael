public class MochilaPD {

    public static class Item {
        public final int peso;
        public final int valor;

        public Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    private static long iteracoes;

    public static int backPackPD(int N, int C, Item[] itens) {
        int[][] maxTab = new int[N + 1][C + 1];
        iteracoes = 0;

        for (int j = 0; j <= C; j++) {
            maxTab[0][j] = 0;
            iteracoes++;
        }
        for (int i = 1; i <= N; i++) {
            maxTab[i][0] = 0;
            iteracoes++;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                iteracoes++;
                if (itens[i].peso <= j) {
                    maxTab[i][j] = Math.max(
                            maxTab[i - 1][j],
                            itens[i].valor + maxTab[i - 1][j - itens[i].peso]);
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }

        return maxTab[N][C];
    }

    public static long getIteracoes() {
        return iteracoes;
    }

    public static void main(String[] args) {
        Item[] itens = new Item[] {
                new Item(0, 0),
                new Item(1, 1),
                new Item(3, 4),
                new Item(4, 5),
                new Item(5, 7)
        };
        int N = 4;
        int C = 7;

        int valorMaximo = backPackPD(N, C, itens);
        System.out.println("--- Mochila PD ---");
        System.out.println("N = " + N + " | C = " + C);
        System.out.println("Valor máximo = " + valorMaximo);
        System.out.println("Iterações = " + getIteracoes());

        Item[] itens2 = new Item[] {
                new Item(0, 0),
                new Item(2, 3),
                new Item(3, 4),
                new Item(4, 5),
                new Item(5, 8),
                new Item(9, 10)
        };
        N = 5;
        C = 10;
        valorMaximo = backPackPD(N, C, itens2);
        System.out.println("\nN = " + N + " | C = " + C);
        System.out.println("Valor máximo = " + valorMaximo);
        System.out.println("Iterações = " + getIteracoes());
    }
}
