package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection getConexao() {

        try {

            final String url ="jdbc:mysql://localhost/banco_exemplo?verifyServerCertificate=false&useSSL=true";
            final String user = "root";
            final String password = "1234567";

            return DriverManager.getConnection(url,user, password);

        } catch (SQLException e) {
            
            throw new RuntimeException(e);

        }

    }

}