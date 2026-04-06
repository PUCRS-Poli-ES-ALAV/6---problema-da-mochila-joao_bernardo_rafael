public class DistanciaEdicao {

    private static long iteracoes;

    public static int distEdProgDina(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] matriz = new int[m + 1][n + 1];

        iteracoes = 0;
        matriz[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            matriz[i][0] = matriz[i - 1][0] + 1;
            iteracoes++;
        }

        for (int j = 1; j <= n; j++) {
            matriz[0][j] = matriz[0][j - 1] + 1;
            iteracoes++;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int custoExtra = (A.charAt(i - 1) == B.charAt(j - 1)) ? 0 : 1;
                matriz[i][j] = Math.min(
                        Math.min(matriz[i - 1][j] + 1, matriz[i][j - 1] + 1),
                        matriz[i - 1][j - 1] + custoExtra);
                iteracoes++;
            }
        }

        return matriz[m][n];
    }

    public static long getIteracoes() {
        return iteracoes;
    }

    public static void main(String[] args) {
        String[][] casos = {
                {"casa", "caso"},
                {"gato", "rato"},
                {"bom", "boum"},
                {"casa", ""},
                {"", "abc"},
                {"algoritmo", "algotimo"}
        };

        System.out.println("--- Testes de Distância de Edição (Programação Dinâmica) ---");
        for (String[] caso : casos) {
            String A = caso[0];
            String B = caso[1];
            int distancia = distEdProgDina(A, B);
            System.out.println("A=\"" + A + "\" B=\"" + B + "\" -> d=" + distancia
                    + " | iteracoes=" + getIteracoes());
        }
    }
}
