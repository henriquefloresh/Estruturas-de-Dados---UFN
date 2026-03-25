from Glicemia import Glicemia

lista = []
obj = Glicemia(191, "11/02/2026", "9:00")
lista.append( obj )

lista.append( Glicemia(90, "11/03/2026", "11:00") )

for i in range(2):
    valor = int(input("Valor glicemia: "))
    data = input("Data [dd//mm/aaa]: ")
    hora = input("Hora [hh:mm]: ")

    lista.append(Glicemia(valor, data, hora))

for item in lista:
    print(f"{item.valor} - {item.data}  - {item.hora}")
