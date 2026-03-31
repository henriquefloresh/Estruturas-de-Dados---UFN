import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Clima> lista = new ArrayList<>();
        String nomeBase = "base.csv";

        try (BufferedReader leitor = new BufferedReader(
                new FileReader(nomeBase, StandardCharsets.UTF_8))) {
            
            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Limpa o caractere '#' caso exista no arquivo original
                linha = linha.replace("#", ""); 
                
                String[] dadosLinha = linha.split(",");
                
                // Evita erros caso haja linhas em branco no arquivo
                if (dadosLinha.length == 4) {
                    Clima objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

                    if (!lista.contains(objClima)) {
                        lista.add(objClima);
                    }
                }
            }

            // Exibe os dados lidos
            System.out.println("--- DADOS LIDOS DO ARQUIVO ---");
            for (Clima item : lista) {
                System.out.println(item);
            }

            
            
            String[] nomesDosMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
            //dois arrays de números inteiros com 12 posições cada.
            int[] contagemCalor = new int[12];
            int[] contagemChuva = new int[12];

            //laço que passa por todos os objetos 'Clima' salvos na nossa 'lista'
            for (Clima item : lista) {
                
                // Para cada item da lista, conta de 0 a 11 para testar todos os meses possíveis
                for (int i = 0; i < 12; i++) {
                    
                    // Verifica se o mês do item atual é igual ao nome do mês na posição 'i'
                    if (item.mes.equalsIgnoreCase(nomesDosMeses[i])) {
                        
                        // Se o mês for igual e a temperatura for "Quente", soma 1 ponto na gaveta 'i' do calor
                        if (item.temperatura.equalsIgnoreCase("Quente")) {
                            contagemCalor[i]++;
                        }
                        
                        // Se a precipitação for "muita", soma 1 ponto na gaveta 'i' da chuva
                        if (item.precipitacao.equalsIgnoreCase("muita")) {
                            contagemChuva[i]++;
                        }
                        
                        // Como já encontramos o mês deste item e somamos os pontos, saímos deste loop 
                        // interno (break) para não perder tempo testando os meses que sobraram.
                        break; 
                    }
                }
            }

            // Variáveis para registrar o recorde de calor e em qual posição (índice) ele ocorreu
            int maxCalor = 0;
            int indiceMaisQuente = 0;

            // Percorre as 12 posições do array de resultados de calor
            for (int i = 0; i < 12; i++) {
                
                // Se os pontos da posição 'i' forem maiores que o nosso recorde atual...
                if (contagemCalor[i] > maxCalor) {
                    maxCalor = contagemCalor[i]; // Atualizamos o número do recorde
                    indiceMaisQuente = i;        // Salvamos a posição 'i' (o mês) que bateu o recorde
                }
            }

            // Variáveis para registrar o recorde de chuva e em qual posição (índice) ele ocorreu
            int maxChuva = 0;
            int indiceMaisChuvoso = 0;

            // Percorre as 12 posições do array de resultados de chuva
            for (int i = 0; i < 12; i++) {
                
                // Se os pontos da posição 'i' forem maiores que o recorde atual
                if (contagemChuva[i] > maxChuva) {
                    maxChuva = contagemChuva[i]; // Atualiza o número do recorde
                    indiceMaisChuvoso = i;       // Salva a posição 'i' (o mês) que bateu o recorde
                }
            }
            // Exibe o resultado final da contagem
            System.out.println("\n RESULTADOS");
            System.out.println("O mês que mais fez calor foi: " + nomesDosMeses[indiceMaisQuente] + " (" + maxCalor + " vezes)");
            System.out.println("O mês que mais choveu foi: " + nomesDosMeses[indiceMaisChuvoso] + " (" + maxChuva + " vezes)");
            
            // FIM DA LÓGICA PRIMITIVA
            

        } catch (Exception e) {
            System.err.println("Ocorreu algum erro... " + e.getMessage());
        }
    }
}
/*arquivo que tem que ler é esta base csv: 
#2020,Janeiro,Quente,muita
#2020,Fevereiro,Quente,muita
#2020,Março,Ameno,média
#2020,Abril,Ameno,pouca
#2020,Maio,Frio,nada
#2020,Junho,Frio,nada
#2020,Julho,Frio,pouca
#2020,Agosto,Ameno,nada
#2020,Setembro,Ameno,pouca
#2020,Outubro,Quente,média
#2020,Novembro,Quente,muita
#2020,Dezembro,Quente,muita
#2021,Janeiro,Quente,muita
#2021,Fevereiro,Quente,média
#2021,Março,Ameno,muita
#2021,Abril,Ameno,pouca
#2021,Maio,Frio,nada
#2021,Junho,Frio,nada
#2021,Julho,Frio,pouca
#2021,Agosto,Frio,nada
#2021,Setembro,Ameno,média
#2021,Outubro,Quente,muita
#2021,Novembro,Quente,média
#2021,Dezembro,Quente,muita
#2022,Janeiro,Quente,muita
#2022,Fevereiro,Quente,muita
#2022,Março,Ameno,média
#2022,Abril,Ameno,pouca
#2022,Maio,Frio,nada
#2022,Junho,Frio,pouca
#2022,Julho,Frio,nada
#2022,Agosto,Ameno,nada
#2022,Setembro,Ameno,pouca
#2022,Outubro,Quente,média
#2022,Novembro,Quente,muita
#2022,Dezembro,Quente,muita
#2023,Janeiro,Quente,muita
#2023,Fevereiro,Quente,média
#2023,Março,Quente,muita
#2023,Abril,Ameno,pouca
#2023,Maio,Ameno,nada
#2023,Junho,Frio,nada
#2023,Julho,Frio,nada
#2023,Agosto,Frio,pouca
#2023,Setembro,Ameno,média
#2023,Outubro,Quente,muita
#2023,Novembro,Quente,muita
#2023,Dezembro,Quente,média
#2024,Janeiro,Quente,muita
#2024,Fevereiro,Quente,muita
#2024,Março,Ameno,média
#2024,Abril,Ameno,pouca
#2024,Maio,Frio,nada
#2024,Junho,Frio,nada
#2024,Julho,Frio,pouca
#2024,Agosto,Frio,nada
#2024,Setembro,Ameno,pouca
#2024,Outubro,Quente,média
#2024,Novembro,Quente,muita
#2024,Dezembro,Quente,muita*/
