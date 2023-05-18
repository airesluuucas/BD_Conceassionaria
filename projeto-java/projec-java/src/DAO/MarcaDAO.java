package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Marca;
import jdbc.FabricaConexao;

public class MarcaDAO {
    
    public MarcaDAO(){

    }

    public void incluir(Marca m){

        Connection c = FabricaConexao.getConexao();

        try {
            
            String sql = "INSERT INTO Marca (nome, sede, valor) VALUES (?,?,?)";
            PreparedStatement stmt = c.prepareStatement(sql);

            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getSede());
            stmt.setDouble(3, m.getValor());
            stmt.execute();

            System.out.println("Dados inseridos com sucesso!!");
            System.out.println(m.toString());
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Marca> mostrar() {

        Connection c = FabricaConexao.getConexao();
        String sql = "SELECT * FROM Marca";

        try {
            
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            List<Marca> m = new ArrayList<>();

            while(r.next()){

                Marca marca = new Marca();
                marca.setId(r.getInt("id"));
                marca.setNome(r.getString("nome"));
                marca.setSede(r.getString("sede"));
                marca.setValor(r.getDouble("valor"));

                m.add(marca);
            } 

            s.close();  
            c.close();

            return m;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public Marca buscar(String nome) {

        String sql = "SELECT * FROM Marca WHERE nome = ?";

        try {

            Connection c = FabricaConexao.getConexao();
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet r = preparedStatement.executeQuery();

            if(r.next()){
                Marca m = new Marca();
                m.setId(r.getInt("id"));
                m.setNome(r.getString("nome"));
                m.setSede(r.getString("sede"));
                m.setValor(r.getDouble("valor"));

                return m;
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void alterar(Marca m) {

        String sql = "UPDATE Marca SET nome = ?, sede = ?, valor = ? WHERE id = ?";
        
        try {

            Connection c = FabricaConexao.getConexao();
            PreparedStatement p = c.prepareStatement(sql);


            p.setString(1, m.getNome());
            p.setString(2, m.getSede());
            p.setDouble(3, m.getValor());
            p.setInt(4, m.getId());
            p.execute();

            System.out.println("Marca alterada com sucesso!!!");
            System.out.println(m.toString());

            c.close();
            p.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void excluir(Marca m) {

        
        String sql = "DELETE FROM Marca WHERE id = ?";

        Connection c = FabricaConexao.getConexao();

        try {
            System.out.println(m.toString());
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, m.getId());
            p.executeUpdate();

            System.out.println("Marca excluida com sucesso!!!");
            c.close();
            p.close();
        } catch (SQLException e) {
       
            e.printStackTrace();
        }

    }
}
