import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        ArrayList<Glicemia> lista = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        //alternativa 1
        Glicemia obj = new Glicemia(191, "11/03/2026", "8:00");
        lista.add( obj );

        //alternativa  2
        lista.add( new Glicemia(98, "11/03/2026", "11:00") );

        //alternativa 3
        int valor;
        String data, hora;
        for (int i = 0; i<3; i++){
            System.out.print("Valor Glicemia: ");
            valor = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Data [dd/mm/aaaa]: ");
            data = teclado.nextLine();

            System.out.print("Hora [hh:mm]: ");
            hora = teclado.nextLine();
          
            lista.add(new Glicemia(valor, data, hora));
        }


        //exibir lista - alt 1
        for (int i=0; i< lista.size(); i++){
            System.out.println(lista.get(i).valor + " - " + lista.get(i).data + " - " + lista.get(i).hora);

        }

        //exibir lista alt 2

        for(Glicemia item : lista){
            System.out.println(item.valor + " - " + item.data + " - " + item.hora);
        }

        teclado.close();
    }
}
