package jdbc;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaEstado {
    public static void main(String [] args) throws SQLException{
        Connection connection = FabricaConexao.getConexao();

        String sql = "CREATE TABLE Estado ("
                + " id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "nome VARCHAR(45) NOT NULL,"
                + "sigla VARCHAR(2) NOT NULL,"
                + "regiao ENUM('Norte','Nordeste','Centro-Oeste','Sudeste', 'Sul') NOT NULL,"
                + "populacao DECIMAL(5,2) NOT NULL,"
                + "PRIMARY KEY (id),"
                + "UNIQUE KEY (nome),"
                + "UNIQUE KEY (sigla)"
                + ")";
        
        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela criada com sucesso!");
        connection.close();
    }
}