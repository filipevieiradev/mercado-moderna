import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoDAO {

    public static void InserirProduto() throws Throwable {


                Scanner scn = new Scanner (System.in);

                System.out.println("Informe o Nome do Produto");
                String nome = scn.nextLine();

                System.out.println("Informe a seção do Produto");
                int secao = scn.nextInt();

                System.out.println("Informe o Valor do Produto");
                Double preco = scn.nextDouble();
                scn.nextLine();

                Connection conexao = FazerConexao.getConnection();

                String sql = "insert into produto (nome, id_secao, preco) Values (?,?,?)";

                PreparedStatement pstmt = conexao.prepareStatement(sql);

                pstmt.setString(1, nome);
                pstmt.setInt(2, secao);
                pstmt.setDouble(3, preco);

                pstmt.execute();

                System.out.println("Produto Inserido com Sucesso");

                pstmt.close();
                scn.close();


    }

    public static void excluirProduto() throws Throwable {


        Scanner scn = new Scanner (System.in);

        System.out.println("Informe o id do produto a ser excluido");
        int id_produto = scn.nextInt();


        Connection conexao = FazerConexao.getConnection();

        String sql = "delete from produto where id_produto = (?)";

        PreparedStatement pstmt = conexao.prepareStatement(sql);

        pstmt.setInt(1, id_produto);

        pstmt.execute();

        System.out.println("Produto Excluído com Sucesso");

        pstmt.close();
        scn.close();


    }

    public static void atualizarProduto() throws Throwable {


        Connection conexao = FazerConexao.getConnection();

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o id do produto a ser atualizado");
        int id_produto = scn.nextInt();

        System.out.println("Informe o novo preço do produto");
        double preco = scn.nextDouble();

        String sql = " UPDATE produto set preco = ? where id_produto = ? ";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setDouble(1,preco);
        stmt.setInt(2,id_produto);

        stmt.execute();

        System.out.println("Preço do produto " + id_produto + " atualizado com sucesso !");

        scn.close();
        stmt.close();


    }

    public static void listarProdutos () throws Throwable{



        //Para consultar algo incialmente é preciso ter uma conexão
        Connection conexao = FazerConexao.getConnection();

        //comando sql a ser executado
        String sql = "Select * from produto";

        //cria a declaracao para receber um resultado do sql
        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        //Cria uma lista de pessoas para armazenar os dados vindo do banco
        List<Produto> produtos = new ArrayList<>();

        //percorre todas as linhas do Resultset
        while (resultado.next()){
            //Pega o resultado do codigo e nome
            int id_produto = resultado.getInt("id_produto");
            String nome = resultado.getString("nome");
            double preco = resultado.getDouble("preco");
            int id_secao = resultado.getInt("id_secao");

            //cria uma pessoa
            produtos.add(new Produto (id_produto,nome, preco,id_secao));

        }

        for (Produto p: produtos) {

            System.out.println(p.getId_produto()+" --->> "+p.getNome()+"--->>"+ p.getPreco()+"--->>"+ p.getId_secao());
        }

        stmt.close();
        conexao.close();

    }

}
