package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Estado;

public class ConsultarEstadoPorParteNome {
    public static void main(String[] args) throws SQLException{
        
            Scanner entrada = new Scanner(System.in);   

            Connection connection = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Estado WHERE nome like ?";

            System.out.println("Informe o nome do estado: ");
            String aaa = entrada.nextLine();

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,"%"+ aaa + "%");
            ResultSet resuSet = stmt.executeQuery();

            List<Estado> estados = new ArrayList<>();

            while(resuSet.next()){
                int id = resuSet.getInt("id");
                String nome = resuSet.getString("nome");
                String sigla = resuSet.getString("sigla");
                String regiao = resuSet.getString("regiao");
                Double popupacao = resuSet.getDouble("populacao");
                estados.add(new Estado(id,nome,sigla, regiao, popupacao));
            }

            for(Estado e: estados){
               System.out.println(e.toString()); 
            }

            stmt.close();
            connection.close();
            entrada.close();
    }
}
