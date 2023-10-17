public class Produto {

    int id_produto;
    String nome;
    double preco;
    int id_secao;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId_secao() {
        return id_secao;
    }

    public void setId_secao(int id_secao) {
        this.id_secao = id_secao;
    }

    public Produto(int id_produto, String nome, double preco, int id_secao) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.preco = preco;
        this.id_secao = id_secao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_produto=" + id_produto +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", id_secao=" + id_secao +
                '}';
    }
}
