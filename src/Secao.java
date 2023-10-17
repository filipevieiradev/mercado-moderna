public class Secao {
    int id_secao;
    String nome;

    public Secao(int id_secao, String nome) {
        this.id_secao = id_secao;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Secao{" +
                "id_secao=" + id_secao +
                ", nome='" + nome + '\'' +
                '}';
    }

    public int getId_secao() {
        return id_secao;
    }

    public void setId_secao(int id_secao) {
        this.id_secao = id_secao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
