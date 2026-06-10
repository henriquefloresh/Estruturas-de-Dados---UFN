import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //ArrayList<String> vertices =  new ArrayList<>();

        ArrayList<String> vertices = LeitorCSV.carregarVertices("mapa.csv");
        Grafo gAssimetrico = new Grafo(vertices);

        LeitorCSV.carregarArestas("mapa.csv", gAssimetrico);

        gAssimetrico.mostrarMatriz();

        System.out.println();

        gAssimetrico.mostrarGrafo();

    }
}