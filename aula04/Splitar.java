import java.util.ArrayList;

public class Splitar {
    public static void main(String[] args) {
        ArrayList<Glicemia> lista = new ArrayList<>();
        //ler a linha
        String linha = "120,11/03/2026,9:00";
        //Splitar a linha
        String vetorLinha[] = linha.split(",");
        //criar objeto Glicemia
        Glicemia obj = new Glicemia(Integer.parseInt(vetorLinha[0]), vetorLinha[1], vetorLinha[2]);

        //System.out.println(obj.valor + " - " + obj.data + " - " + obj.hora);

        //adicionar na lista
        if(!lista.contains(obj)){
            lista.add(obj);
        }

        //exibir a lista
        for(Glicemia item : lista){
            System.out.println(item.valor + " - " + item.data + " - " + item.hora);
        }


    }
}
