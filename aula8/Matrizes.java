import java.util.List;

public class Matrizes {
    /**
     * método de classe que inicializa com zeros a matriz
     * @param m matriz de inteiro
     * @param qtdeLinhas quantidade de linhas
     * @param qtdeColunas quantidade de colunas
     */
    public static void inicalizarMatrizInteiro(int m[][], int qtdeLinhas, int qtdeColunas) {
        for (int lin = 0; lin < qtdeLinhas; lin++) {
            for (int col = 0; col < qtdeColunas; col++){
                m[lin] [col] = 0;
            }
        }
        
    }

    /**
     * método de classe que exibe uma matriz de qualquer tipo
     * @param m matriz que será exibida
     * @param qtdeLinhas quantidade de linhas
     * @param qtdeColunas quantidade de colunas
     */
    public static void exibirMatriz(int m[][], int qtdeLinhas, int qtdeColunas) {
        for (int lin = 0; lin < qtdeLinhas; lin++) {
            for (int col = 0; col < qtdeColunas; col++){
                System.out.print(m[lin][col] + " \t");
            }
            System.out.println();
        }
    }

    /**
     * método de clase que recebe uma matriz com muitos valores nulos e a converte para uma lista de matrizes especiais 
     * @param m matriz com valores nulos ou sua maioria
     * @param qtdeLinhas quantidade de linhas
     * @param qtdeColunas quanridade de colunas
     * @param lista lista que armazena valores
     */
    public static void converter(int m[][], int qtdeLinhas, int qtdeColunas, List<Dado> lista ){
        for (int lin = 0; lin < qtdeLinhas; lin++) {
            for (int col = 0; col < qtdeColunas; col++){
                if (m[lin][col] != 0 ){
                    lista.add(new Dado(m[lin][col], lin, col));
                }
            }
        }
    }

    public static void exibirLista(List<Dado> lista){
        for (Dado item : lista){
            System.out.println(item);
        }
        System.out.println("Total de elementos não nulos: " + lista.size());
    }
}
