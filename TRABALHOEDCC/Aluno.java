package pkg;

public class Aluno {
    private String nome;
    private String curso;
    private String sexo;
    private int anoIngresso;

    public Aluno(String nome, String curso, String sexo, int anoIngresso) {
        this.nome = nome;
        this.curso = curso;
        this.sexo = sexo;
        this.anoIngresso = anoIngresso;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getSexo() {
        return sexo;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
               ", Curso: " + curso +
               ", Sexo: " + sexo +
               ", Ano de Ingresso: " + anoIngresso;
    }
}
