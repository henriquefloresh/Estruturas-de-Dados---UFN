lista_nomes = []

#add nomes na lista
lista_nomes.append("Guilherme")
lista_nomes.append("Bruno")
lista_nomes.append("Leonardo")

#exibir a lista inteira
print(lista_nomes)

#remove um nome da lista
if len(lista_nomes) != 0:
    nome = input("Digite um nome: ") 
    if lista_nomes.__contains__(nome):
        lista_nomes.remove(nome)
    else:
        print(nome,"Não está na lista")

    print(lista_nomes)
else: 
    print("Lista vazia...")
