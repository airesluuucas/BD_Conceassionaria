package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Responsavel;
import jdbc.FabricaConexao;

public class ResponsavelDAO {

    public void inserir(Responsavel r) {

        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "INSERT INTO Responsavel (id, nome, passe) VALUES (?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setInt(1, r.getId());
            p.setString(2, r.getNome());
            p.setInt(3, r.getPasse());
            p.execute();

            System.out.println(r.toString());
            System.out.println("_____________________________________________");
            System.out.println("Dados do responsavel inseridos com sucesso!!!");
            System.out.println("_____________________________________________");

            c.close();
            p.close();
            
        } catch (Exception e) {
           
            e.printStackTrace();

        }

    }

    public void listar() {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Responsavel";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            System.out.println("_____________________________________________________________");
            System.out.println("Dados da tabela responsavel!");
            System.out.println("_____________________________________________________________");

            while(r.next()){

                Responsavel responsavel = 
                new Responsavel(r.getInt("id"), r.getString("nome"), r.getInt("passe"));
                System.out.println(responsavel.toString());
                System.out.println("_____________________________________________________________");

            }

            c.close();
            s.close();
            r.close();
            

        } catch (Exception e) {
            
            e.printStackTrace();

        }
    }

    public List<Responsavel> listarComRetorno() {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Responsavel";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            List<Responsavel> lc = new ArrayList<>();

            System.out.println("_____________________________________________________________");
            System.out.println("Dados da tabela responsavel!");
            System.out.println("_____________________________________________________________");


            while(r.next()){

                Responsavel responsavel = new 
                Responsavel(r.getInt("id"), r.getString("nome"), r.getInt("passe"));

                lc.add(responsavel);

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

    public Responsavel buscar(String nome) {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Responsavel WHERE nome = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nome);
            ResultSet r = p.executeQuery();

            if(r.next()){

                Responsavel resp = new Responsavel(r.getInt("id"), r.getString("nome"), r.getInt("passe"));

                p.close();
                c.close();
                r.close();
                return resp;
            }

        } catch (Exception e) {
           
            e.printStackTrace();

        }

        return null;

    }

    public void excluir(Responsavel r) {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "DELETE FROM Responsavel WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, r.getId());
            p.executeUpdate();

            System.out.println("__________________________________________");
            System.out.println("Dados do responsavel excluido com sucesso!");
            System.out.println("__________________________________________");

        } catch (Exception e) {
           
            e.printStackTrace();

        }

    }

    public void alterar(Responsavel r) {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "UPDATE Responsavel SET nome = ?, passe = ? WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, r.getNome());
            p.setInt(2, r.getPasse());
            p.setInt(3, r.getId());

            p.executeUpdate();
            System.out.println("_______________________________________");
            System.out.println("Responsavel alterado com sucesso!");
            System.out.println("_______________________________________");
            r.toString();

        } catch (Exception e) {
            
            e.printStackTrace();

        }

    }

}
