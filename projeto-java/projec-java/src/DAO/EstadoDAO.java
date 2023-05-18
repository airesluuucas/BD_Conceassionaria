package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Estado;
import jdbc.FabricaConexao;

public class EstadoDAO {

    public EstadoDAO() {
    }

    public void inserir(Estado estado) {

        Connection connection = FabricaConexao.getConexao();
    
        try {

            String sql = "INSERT INTO Estado (nome, sigla, regiao, populacao) VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, estado.getNome());
            stmt.setString(2, estado.getSigla());
            stmt.setString(3, estado.getRegiao());
            stmt.setDouble(4, estado.getPopulacao());
            stmt.execute();
            System.out.println("Dados inseridos com sucesso!!");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Estado> listar(){

        Connection connection = FabricaConexao.getConexao();
        String sql = "Select * from Estado";

        try {
            Statement statement = connection.createStatement();
            ResultSet resuSet = statement.executeQuery(sql);
            List<Estado> estado = new ArrayList<>();

            while(resuSet.next()){
                Estado e = new Estado();
                e.setId(resuSet.getInt("id"));
                e.setNome(resuSet.getString("Nome"));
                e.setSigla(resuSet.getString("sigla"));
                e.setPopulacao(resuSet.getDouble("populacao"));
                e.setRegiao(resuSet.getString("regiao"));
                estado.add(e);
            }
            connection.close();
            return estado;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void excluir(String sigla){

        try {

            String sql = "DELETE FROM Estado WHERE sigla = ?";
            Connection connection = FabricaConexao.getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, sigla);
            preparedStatement.executeUpdate();
            System.out.println("Estado excluido com sucesso!");

            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir");
        }

    }

    public Estado buscar(String sigla){
            
            Connection connection = FabricaConexao.getConexao();

            String sql ="SELECT * FROM Estado WHERE sigla = ?";

            try {

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, sigla);
                ResultSet resuSet = preparedStatement.executeQuery();
                
                resuSet.next();
                Estado e = new Estado();

                e.setId(resuSet.getInt("id"));
                e.setNome(resuSet.getString("nome"));
                e.setSigla(resuSet.getString("sigla"));
                e.setRegiao(resuSet.getString("regiao"));
                e.setPopulacao(resuSet.getDouble("populacao"));

                connection.close();
                return e;

            } catch (SQLException e) {
                System.out.println("ERRO" );
                e.printStackTrace();
                return null;
            }
           
    }

    public void alterar(Estado est){

        String update = "UPDATE Estado SET nome = ?, sigla = ? , regiao = ? , populacao = ? WHERE id = ?";

        try {

            Connection connection = FabricaConexao.getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(update);

                preparedStatement.setString(1, est.getNome());
                preparedStatement.setString(2, est.getSigla());
                preparedStatement.setString(3, est.getRegiao());
                preparedStatement.setDouble(4, est.getPopulacao());
                preparedStatement.setInt(5, est.getId());
                preparedStatement.execute();

                System.out.println("Alteração concluida com sucesso!!!");
                preparedStatement.close();
                connection.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }

}