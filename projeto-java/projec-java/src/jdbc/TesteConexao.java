package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    
    public static void main(String[] args) throws SQLException {
                
        final String url ="jdbc:mysql://localhost:3306/www?verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "1234567";

        Connection con = DriverManager.getConnection(url, user, password);

        System.out.println("Conexão efetuada com sucesso!");
        con.close();
    }
}
