import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorCSV{
    public static ArrayList<String> carregarVertices(String nomeArquivo) {

        ArrayList<String> vertices = new ArrayList<>();

        try {
            File arquivo = new File(nomeArquivo);
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                String[] dados = linha.split(",");

                String origem = dados[0];
                String destino = dados[1];

                if (!vertices.contains(origem)) {
                    vertices.add(origem);
                }

                if (!vertices.contains(destino)) {
                    vertices.add(destino);
                }
            }

            leitor.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo.");
        }

        for (int i = 0; i < vertices.size() - 1; i++) {
            for (int j = i + 1; j < vertices.size(); j++) {

                if (vertices.get(i).compareTo(vertices.get(j)) > 0) {

                    String aux = vertices.get(i);
                    vertices.set(i, vertices.get(j));
                    vertices.set(j, aux);
                }
            }
        }
        return vertices;
    }

    public static void carregarArestas(String nomeArquivo, Grafo g) {

        try {
            File arquivo = new File(nomeArquivo);
            Scanner leitor = new Scanner(arquivo);

             while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                String[] dados = linha.split(",");

                String origem = dados[0];
                String destino = dados[1];

                g.inserirAresta(
                    g.pegarIndice(origem),
                    g.pegarIndice(destino)
                );
            }

            leitor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   
