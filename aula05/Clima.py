from Clima import Clima

lista = []
nome_base = "base.csv"

contagem_meses = {}

try:
    leitor = open(nome_base, "r", encoding="utf-8")

    for linha in leitor:
        dados_linha = linha.strip().split(",")

        obj_clima = Clima(
            dados_linha[0],
            dados_linha[1],
            dados_linha[2],
            dados_linha[3]
        )

        if obj_clima not in lista:
            lista.append(obj_clima)

        # usando os atributos da classe
        if obj_clima.precipitacao == "muita":
            mes = obj_clima.mes

            if mes in contagem_meses:
                contagem_meses[mes] += 1
            else:
                contagem_meses[mes] = 1

    leitor.close()

    # encontrar o mês com mais chuva
    mes_mais_chuva = max(contagem_meses, key=contagem_meses.get)

    print("\nMês que mais chove:", mes_mais_chuva)
    print("Quantidade de vezes com muita chuva:", contagem_meses[mes_mais_chuva])

except Exception as e:
    print("Ocorreu algum erro....", e)

#arquivo que tem que ler é esta base csv: 
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
#2024,Dezembro,Quente,muita
