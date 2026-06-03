import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> vertices =  new ArrayList<>();
        //populando vertices
        // vertices.add("a");
        // vertices.add("b");
        // vertices.add("c");
        // vertices.add("d");
        // vertices.add("e");

        //TRABALHO AQUI
        //ler arquivo csv, chamado mapa.csv do tipo
            //a,b
            //b,c
            //b,d
            //d,a
            //d,b
            //d,c
            //e,d
        //extrair os vertices presentes no csv e adiciona-los na lista de vertices(lembrar de ordenar)
        
        Grafo gAssimetrico = new Grafo(vertices);

        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("a"), gAssimetrico.pegarIndice("b"));

        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("b"), gAssimetrico.pegarIndice("c"));

        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("b"), gAssimetrico.pegarIndice("d"));
        
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("c"), gAssimetrico.pegarIndice("e"));

        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("a"));
        
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("b"));

        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("c"));

        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("e"), gAssimetrico.pegarIndice("d"));

        gAssimetrico.mostrarMatriz();
        System.out.println();
        gAssimetrico.mostrarGrafo();
    }
}
