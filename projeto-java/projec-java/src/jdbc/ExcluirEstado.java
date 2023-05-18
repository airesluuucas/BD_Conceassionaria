package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ExcluirEstado {

    public static void main(String[] args) throws SQLException{
        
        Scanner entrada = new Scanner( System.in);

        System.out.println("Informe o sigla");
        String sigla = entrada.nextLine();

        Connection connection = FabricaConexao.getConexao();
        String sql = "DELETE FROM Estado WHERE sigla = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, sigla);

        if(statement.executeUpdate()> 0){

            System.out.println("Estado excluido com sucesso!");

        }else{

            System.out.println("Nada feito");
        }

        connection.close();
        entrada.close();
    }
    
}
