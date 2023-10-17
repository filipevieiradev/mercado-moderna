import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FazerConexao {

    public static Connection getConnection (){

        try{
            final String url = "jdbc:postgresql://localhost:5432/postgres";

            final String usuario = "postgres";

            final String senha = "123";

            return DriverManager.getConnection(url,usuario,senha);
        }

        catch (SQLException e){

            throw new RuntimeException("Deu ruim Playboy"+e);
        }
    }

}
