package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Montadora;
import jdbc.FabricaConexao;

public class MontadoraDAO {

    public void inserir(Montadora m) {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "INSERT INTO Montadora (id, nome, cidade_id) VALUES (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, m.getId());
            p.setString(2, m.getNome());
            p.setInt(3, m.getCidade_id());

            p.execute();
            System.out.println(m.toString());

            System.out.println("__________________________________________");
            System.out.println("Dados da Montadora inseridos com sucesso!!");
            System.out.println("__________________________________________");

            c.close();
            p.close();

        } catch (Exception e) {
            
            e.printStackTrace();

        }

    }

    public void listar() {

        try {
            
            String sql ="SELECT * FROM Montadora";
            Connection c = FabricaConexao.getConexao();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            System.out.println("_______________________________________");
            System.out.println("Dados da tabela Montadora!");
            System.out.println("_______________________________________");
            while(r.next()){

                Montadora m = new Montadora
                (r.getInt("id"), r.getString("nome"), r.getInt("cidade_id"));

                System.out.println(m.toString());
                System.out.println("_______________________________________");
            }

            c.close();
            s.close();
            r.close();

        } catch (Exception e) {
           
            e.printStackTrace();

        }

    }

    public List<Montadora> listarMont() {

        try {
            
            String sql ="SELECT * FROM Montadora";
            Connection c = FabricaConexao.getConexao();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            List<Montadora> mont= new ArrayList<>();

            
            System.out.println("_______________________________________");
            System.out.println("Dados da tabela Montadora!");
            System.out.println("_______________________________________");

            while(r.next()){

                Montadora m = 
                new Montadora(r.getInt("id"), r.getString("nome"), r.getInt("cidade_id"));

                System.out.println(m.toString());
                System.out.println("_______________________________________");
                mont.add(m);
            }
            
            c.close();
            s.close();
            r.close();

            return mont;
        } catch (Exception e) {
           
            e.printStackTrace();

        }

        return null;
    }

    public Montadora buscar(String nome) {

        try {

            String sql ="SELECT * FROM Montadora WHERE nome = ?";
            Connection c = FabricaConexao.getConexao();
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nome);
            ResultSet r = p.executeQuery();

            if(r.next()){

                Montadora m = 
                new Montadora(r.getInt("id"), r.getString("nome"), r.getInt("cidade_id"));
           
                c.close();
                p.close();
                r.close();
                return m;

            }
        
        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public void excluir(Montadora m) {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "DELETE FROM Montadora WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, m.getId());
            System.out.println("_______________________________________");
            System.out.println("Montadora");
            System.out.println(m.toString());
            System.out.println("_______________________________________");


            p.executeUpdate();


            System.out.println("_______________________________________");
            System.out.println("Montadora excluida com sucesso!");
            System.out.println("_______________________________________");

            c.close();
            p.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();

        }
    }

    public void alterar(Montadora montadora) {

        try {
            
            String sql = "UPDATE Montadora SET nome = ? WHERE id = ?";
            Connection connection = FabricaConexao.getConexao();
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, montadora.getNome());
            p.setInt(2, montadora.getId());
            p.execute();

            System.out.println(montadora.toString());
            System.out.println("_______________________________________");
            System.out.println("Montadora alterada com sucesso!");
            System.out.println("_______________________________________");

            connection.close();
            p.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
}