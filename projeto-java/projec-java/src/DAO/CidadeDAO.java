package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cidade;
import jdbc.FabricaConexao;

public class CidadeDAO {

    public void inserir(Cidade c) {

        
        try {

            Connection connection = FabricaConexao.getConexao();
            String sql = "INSERT INTO Cidade (id, nome, estado_id) VALUES (?,?,?)";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setInt(1, c.getId());
            p.setString(2, c.getNome());
            p.setInt(3, c.getEstado_id());

            p.execute();
            System.out.println(c.toString());
            System.out.println("_______________________________________");
            System.out.println("Dados da cidade inseridos com sucesso!!");
            System.out.println("_______________________________________");

            p.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

	public void listar() {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Cidade";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            while(r.next()){

                Cidade cidade = new Cidade
                (r.getInt("id"), r.getString("nome"), r.getInt("Estado_id"));
           
                System.out.println(cidade.toString());

            }

            c.close();
            s.close();
            r.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    public List<Cidade> listarCRetorno() {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Cidade";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            List<Cidade> lc = new ArrayList<>();

            while(r.next()){

                Cidade cidade = new Cidade
                (r.getInt("id"), r.getString("nome"), r.getInt("Estado_id"));
                lc.add(cidade);
                System.out.println(cidade.toString());

            }

            c.close();
            s.close();
            r.close();

            return lc;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

    public Cidade buscar(String nome) {

        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Cidade WHERE nome = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1,nome);
            ResultSet r = p.executeQuery();

            r.next();
            Cidade cidade = 
            new Cidade(r.getInt("id"), r.getString("nome"),r.getInt("Estado_id"));
            
            c.close();
            p.close();
            r.close();
            return cidade;

        } catch (Exception e) {
            
            System.out.println("ERRO" );
            e.printStackTrace();
            return null;

        }
        
    }

    public void excluir(Cidade c) {

        try {
            
            Connection connection = FabricaConexao.getConexao();
            String sql = "DELETE FROM Cidade WHERE id = ?";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setInt(1, c.getId());
            p.executeUpdate();

            System.out.println("_______________________________________");
            System.out.println("Cidade excluida com sucesso!");
            System.out.println("_______________________________________");

        } catch (Exception e) {
            
            e.printStackTrace();

        }

    }

    public void alterar(Cidade c) {

        try {
            
            Connection connection = FabricaConexao.getConexao();
            String sql = "UPDATE Cidade SET nome = ? WHERE id = ?";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setInt(1, c.getId());
            p.setString(2, c.getNome());
            p.execute();

            System.out.println(c.toString());
            System.out.println("_______________________________________");
            System.out.println("Cidade alterada com sucesso!");
            System.out.println("_______________________________________");

            p.close();
            connection.close();
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
    
}
