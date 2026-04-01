import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Chamando {
    public static void main(String[] args) {
        Queue<Integer> filaNormal = new LinkedList<>();
        Queue<Integer> filaPrioritaria = new LinkedList<>();
        int contarNormal = 0;
        int contarPrioritaria = 500;
        int totalAtendimentos = 0;
        Scanner teclado = new Scanner(System.in);
        String opcao = " ";
        String qualFila = " ";


        do {
            System.out.println("M E N U");
            System.out.println("1 - Ficha Normal");
            System.out.println("2 - Ficha Prioritária");
            System.out.println("3 - Chamar Ficha");
            System.out.println("4 - Mostrar Filas de atendimento");
            System.out.println("5 - Sair");
            System.out.print("Opcao: ");
            opcao = teclado.nextLine();
            switch (opcao) {
            case "1":
                System.out.println("Gerando ficha normal..." + contarNormal);
                filaNormal.offer(contarNormal);
                contarNormal++;
                break;
            case "2":
                System.out.println("Gerando ficha prioritária..." + contarPrioritaria);
                filaNormal.offer(contarPrioritaria);
                contarPrioritaria++;
                break;
            case "3":
                int fichaAtendida = -1;
                if (totalAtendimentos % 3 == 0){ //a cada 3 chamadas normal, chama 1 prioritaria
                    qualFila = "PRIORITARIA";
                }else {//chamar normal
                    qualFila = "NORMAL";
                }
                //PELO NUMERO DE ATENDIMENTO EM PRIORITARIA
                if (qualFila.equals("PRIORITARIA") && !filaPrioritaria.isEmpty()){
                    fichaAtendida = (int)filaPrioritaria.poll();
                    totalAtendimentos++;
                // PELO NUMERO DE ATENDIMENTO É NORMAL
                } else if (qualFila.equals("NORMAL") && !filaNormal.isEmpty()){
                    fichaAtendida = (int)filaNormal.poll();
                    totalAtendimentos++;
                    //DEVERIA SER NORMAL, MAS ESTA VAZIA... ENTAO TENTA PRIORITARIA
                } else if (qualFila.equals("NORMAL") && !filaNormal.isEmpty() && !filaPrioritaria.isEmpty()){
                    qualFila = "PRIORITARIA";
                    fichaAtendida = (int)filaPrioritaria.poll();
                    totalAtendimentos++;
                }
                if (fichaAtendida != -1){
                    System.out.println("Chamando fichas..." + qualFila + ": " + fichaAtendida);
                } else{
                    System.out.println("Ninguém para ser atendido!");
                }
                break;
            case"4":
                System.out.println("Mostrando fichas faltantes...");
                int totalNormalFaltantes = filaNormal.size();
                int totalPrioritariaFaltantes = filaNormal.size();

                System.out.println("Fila normal: " + filaNormal);
                System.out.println("Total de fichas... " + totalNormalFaltantes);

                System.out.println("Fila Prioritária: " + filaPrioritaria);
                System.out.println("Total de fichas... " + totalPrioritariaFaltantes);

                
                break;
            case "5":
                System.out.println("lista encerrada....");
        
            default:
                System.out.println("Opção Inválida.");
                break;
        }


        }while (!opcao.equals("5"));

        

    }
    
}
