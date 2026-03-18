import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//Salvei o arquivo como Principal
public class Principal {
    public static void main(String[] args) {
        List<Clima> lista = new ArrayList<>();
        String nomeBase = "base.csv";

        // O try-with-resources já fecha o arquivo automaticamente (igual ao 'with' do Python)
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(nomeBase, StandardCharsets.UTF_8))) {
            
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dadosLinha = linha.split(",");
                
                Clima objClima = new Clima(dadosLinha[0],dadosLinha[1],dadosLinha[2], dadosLinha[3]);

                // Requer que o método equals() esteja implementado na classe Clima
                if (!lista.contains(objClima)) {
                    lista.add(objClima);
                }
            }

            for (Clima item : lista) {
                System.out.println(item);
            }

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
