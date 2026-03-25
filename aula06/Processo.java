public class Processo{
    public int id;
    public String descricao;

    public Processo(int id, String descricao){ //Metodo construtor
        this.id = id;
        this.descricao = descricao;
    }


    @Override
    public boolean equals(Object obj) {//Se reescreve este recurso para definir a chave primária
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Processo other = (Processo) obj;
        if (id != other.id)
            return false;
        return true;
    }


    @Override
    public String toString() { //serve para organizar como exibir o objeto dentro de uma lista
        return "Processo [id=" + id + ", descricao=" + descricao + "]";
    }

    //esses dois recursos servem para garantir o tratamento de objetos em lista(botão direito -> Source Action)

    
}
