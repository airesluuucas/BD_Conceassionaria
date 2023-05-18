package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Carro;
import jdbc.FabricaConexao;

public class CarroDAO {

    public void inserir(Carro carro) {

        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "INSERT INTO Carro (id, modelo, cor, valor, ano, montadora_id, marca_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, carro.getId());
            p.setString(2, carro.getModelo());
            p.setString(3, carro.getCor());
            p.setDouble(4, carro.getValor());
            p.setInt(5, carro.getAno());
            p.setInt(6, carro.getMontadora_id());
            p.setInt(7, carro.getMarca_id());

            p.execute();
            System.out.println(carro.toString());
            System.out.println("_______________________________________");
            System.out.println("Dados da carro inseridos com sucesso!!!");
            System.out.println("_______________________________________");

            c.close();
            p.close();
            
        } catch (Exception e) {
          
            e.printStackTrace();

        }

    }

    public void listar() {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Carro";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            System.out.println("_____________________________________________________________");
            System.out.println("Dados da tabela carros!");
            System.out.println("_____________________________________________________________");

            while(r.next()){
                
                Carro carro = new Carro
                (r.getInt("id"),r.getString("modelo"),
                r.getString("cor"), r.getDouble("valor"), 
                r.getInt("ano"), r.getInt("montadora_id"), 
                r.getInt("marca_id"));
                System.out.println(carro.toString());
                System.out.println("_____________________________________________________________");

            }
            r.close();
            s.close();
            r.close();

        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

    }

    public List<Carro> listarCRetorno() {


        try {
            
            Connection connection =FabricaConexao.getConexao();
            String sql = "SELECT * FROM Carro";
            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery(sql);
            List<Carro> lc = new ArrayList<>();

            while(r.next()){
                Carro c = new Carro(r.getInt("id"), r.getString("modelo"), 
                r.getString("cor"), r.getDouble("valor"),
                r.getInt("ano"), r.getInt("montadora_id"), 
                r.getInt("marca_id"));
               
                 lc.add(c);
            }

            connection.close();
            s.close();
            r.close();

            return lc;

        } catch (Exception e) {
           
            e.printStackTrace();

        }

        return null;

    }

    public Carro buscar(String modelo) {
       
        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Carro WHERE modelo = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, modelo);
            ResultSet r = p.executeQuery();

                if(r.next()){

                    Carro carro = new Carro(r.getInt("id"), r.getString("modelo"), 
                    r.getString("cor"), r.getDouble("valor"),
                    r.getInt("ano"), r.getInt("montadora_id"), 
                    r.getInt("marca_id"));
    
                    c.close();
                    p.close();
                    r.close();

                    return carro;
                
                }

        } catch (Exception e) {
            
            e.printStackTrace();

        }
        
        return null;

    }

    public void excluir(Carro carro) {

        try {
            
            Connection connection = FabricaConexao.getConexao();
            String sql = "DELETE FROM Carro WHERE id = ?";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setInt(1, carro.getId());
            p.executeUpdate();

            System.out.println("_______________________________________");
            System.out.println("Dados do carro excluido com sucesso!");
            System.out.println("_______________________________________");

            connection.close();
            p.close();
        } catch (Exception e) {
            
            e.printStackTrace();

        }
    }

    public void alterar(Carro carro) {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "UPDATE Carro SET modelo = ?, cor = ?, valor = ?, ano = ? WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1,carro.getModelo() );
            p.setString(2, carro.getCor());
            p.setDouble(3, carro.getValor());
            p.setInt(4, carro.getAno());
            p.setInt(5, carro.getId());

            p.executeUpdate();
            
            System.out.println(carro.toString());
            System.out.println("_______________________________________");
            System.out.println("Carro alterado com sucesso!");
            System.out.println("_______________________________________");

            c.close();
            p.close();

        } catch (Exception e) {
           
            e.printStackTrace();

        }

    }
   
}