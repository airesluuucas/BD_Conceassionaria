package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {
        
        final String url ="jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "1234567";

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS banco_exemplo");
        
        System.out.println("Banco Criado com sucesso");
        con.close();
        
    }
}
