import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecaoDAO {

    public static void InserirSecao() throws Throwable {


        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o Nome da Secao");
        String nome = scn.nextLine();

        Connection conexao = FazerConexao.getConnection();

        String sql = "insert into secao (nome) Values (?)";

        PreparedStatement pstmt = conexao.prepareStatement(sql);

        pstmt.setString(1, nome);

        pstmt.execute();

        System.out.println("Secao Inserida com Sucesso");

        pstmt.close();
        scn.close();


    }

    public static void excluirSecao() throws Throwable {


        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o id da seçao a ser excluida");
        int id_secao = scn.nextInt();


        Connection conexao = FazerConexao.getConnection();

        String sql = "delete from secao where id_secao = (?)";

        PreparedStatement pstmt = conexao.prepareStatement(sql);

        pstmt.setInt(1, id_secao);

        pstmt.execute();

        System.out.println("Seção Excluída com Sucesso");

        pstmt.close();
        scn.close();

    }

    public static void atualizarSecao() throws Throwable {


        Connection conexao = FazerConexao.getConnection();

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o id da seção a ser atualizada");
        int id_secao = scn.nextInt();

        System.out.println("Informe a nova seção do produto");
        String nome = scn.next();

        String sql = " UPDATE secao set nome = ? where id_secao = ? ";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1,nome);
        stmt.setInt(2,id_secao);

        stmt.execute();

        System.out.println("Seção atualizada com sucesso !");

        scn.close();
        stmt.close();


    }

    public static void listarsecao () throws Throwable{



        //Para consultar algo incialmente é preciso ter uma conexão
        Connection conexao = FazerConexao.getConnection();

        //comando sql a ser executado
        String sql = "Select * from secao";

        //cria a declaracao para receber um resultado do sql
        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        //Cria uma lista de pessoas para armazenar os dados vindo do banco
        List<Secao> secao = new ArrayList<>();

        //percorre todas as linhas do Resultset
        while (resultado.next()){
            //Pega o resultado do codigo e nome
            int id_secao = resultado.getInt("id_secao");
            String nome = resultado.getString("nome");



            //cria uma pessoa
            secao.add(new Secao (id_secao,nome));

        }

        for (Secao p: secao) {

            System.out.println(p.getId_secao()+" --->> "+p.getNome());
        }

        stmt.close();
        conexao.close();

    }

}
