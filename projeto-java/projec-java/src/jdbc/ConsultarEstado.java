package jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Estado;

public class ConsultarEstado {
    
    public static void main(String[] argas) throws SQLException {
        Connection connection = FabricaConexao.getConexao();
        String sql = "SELECT * FROM Estado";

        Statement stmt = connection.createStatement();
        ResultSet resuSet = stmt.executeQuery(sql);

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
        
    }
}
