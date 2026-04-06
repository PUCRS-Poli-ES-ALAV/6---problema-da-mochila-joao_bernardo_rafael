public class DistanciaEdicao {
    //contador de iteracoes do algoritmo de programacao dinamica
    private static long iteracoes;
    //calcula a distancia de edicao entre A e B usando programacao dinamica
    public static int distEdProgDina(String A, String B) {
        int m = A.length(); //tamanho de A
        int n = B.length(); //tamanho de B
        int[][] matriz = new int[m + 1][n + 1]; //tabela de custos
        iteracoes = 0; //zera contador
        matriz[0][0] = 0; //custo de vazio para vazio
        //inicializa primeira coluna: remover caracteres de A
        for (int i = 1; i <= m; i++) {
            matriz[i][0] = matriz[i - 1][0] + 1;
            iteracoes++;
        }
        //inicializa primeira linha: inserir caracteres em A
        for (int j = 1; j <= n; j++) {
            matriz[0][j] = matriz[0][j - 1] + 1;
            iteracoes++;
        }
        //preenche a tabela principal comparando pares de caracteres
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int custoExtra = (A.charAt(i - 1) == B.charAt(j - 1)) ? 0 : 1; //match ou substituicao
                matriz[i][j] = Math.min(
                        Math.min(matriz[i - 1][j] + 1, matriz[i][j - 1] + 1),
                        matriz[i - 1][j - 1] + custoExtra);
                iteracoes++; //conta iteracao na tabela
            }
        }
        return matriz[m][n]; //retorna o custo minimo de edicao
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

        System.out.println("--- Testes de Distancia de Edicao (Programacao Dinamica) ---");
        for (String[] caso : casos) {
            String A = caso[0];
            String B = caso[1];
            int distancia = distEdProgDina(A, B); //calcula distancia para cada caso
            System.out.println("A=\"" + A + "\" B=\"" + B + "\" -> d=" + distancia
                    + " | iteracoes=" + getIteracoes());
        }
    }
}
