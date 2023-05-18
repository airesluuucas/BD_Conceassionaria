package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.Scanner;

public class InserirEstado {
    public static void main(String[] args) throws SQLException{

        //Scanner entrada = new Scanner(System.in);

       // System.out.println("Informe o nome: ");
       // String nome = entrada.nextLine();

        Connection connection = FabricaConexao.getConexao();

        String sql = "INSERT INTO Estado (nome, sigla, regiao, populacao) VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, "aaaa");
        stmt.setString(2, "Ab");
        stmt.setString(3, "Norte");
        stmt.setDouble(4, 1.00);

        stmt.execute();
        System.out.println("Dados inseridos com sucesso!!");
        //entrada.close();
    }
}