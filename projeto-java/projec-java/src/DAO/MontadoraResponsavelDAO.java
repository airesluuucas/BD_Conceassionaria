package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Montadora;
import Model.MontadoraResponsavel;
import Model.Responsavel;
import jdbc.FabricaConexao;

public class MontadoraResponsavelDAO {

    public void inserir(Responsavel r, Montadora m) {

        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "INSERT INTO Mont_Resp (montadora_id, responsavel_id) VALUES (?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setInt(1, m.getId());
            p.setInt(2, r.getId());

            p.execute();

            System.out.println(r.toString());
            System.out.println("__________________________________________________");
            System.out.println("Dados da tabela Mont_Resp inseridos com sucesso!!!");
            System.out.println("__________________________________________________");

            c.close();
            p.close();
            
        } catch (Exception e) {
           
            e.printStackTrace();

        }
        
    }

    public List<MontadoraResponsavel> listarComRetorno() {

        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Mont_Resp";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            List<MontadoraResponsavel> mr = new ArrayList<>();

            System.out.println("_____________________________________________________________");
            System.out.println("Dados da tabela Mont_Resp!");
            System.out.println("_____________________________________________________________");

            while(r.next()){

                MontadoraResponsavel m = new 
                MontadoraResponsavel(r.getInt("montadora_id"), r.getInt("responsavel_id"));

                mr.add(m);

            }

            c.close();
            s.close();
            r.close();

            return mr;

        } catch (Exception e) {
           
            e.printStackTrace();

        }
        return null;
    }

    public void listar() {

        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Mont_Resp";
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            System.out.println("_____________________________________________________________");
            System.out.println("Dados da tabela Mont_Resp!");
            System.out.println("_____________________________________________________________");

            if(r.next()){

                MontadoraResponsavel m = new 
                MontadoraResponsavel(r.getInt("montadora_id"), r.getInt("responsavel_id"));

                System.out.println(m.toString());

            }

            c.close();
            s.close();
            r.close();

        } catch (Exception e) {
           
            e.printStackTrace();

        }

    }

    public MontadoraResponsavel buscar(Responsavel r, Montadora m) {

        try {

            Connection c = FabricaConexao.getConexao();
            String sql = "SELECT * FROM Mont_Resp WHERE montadora_id = ? and responsavel_id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, m.getId());
            p.setInt(2, r.getId());
            ResultSet resultSet = p.executeQuery();

            if(resultSet.next()){

                MontadoraResponsavel mr = new MontadoraResponsavel(resultSet.getInt("responsavel_id"),resultSet.getInt("montadora_id"));

                p.close();
                c.close();
                resultSet.close();

                return mr;
            }

        } catch (Exception e) {
           
            e.printStackTrace();

        }

        return null;

    }

    public MontadoraResponsavel excluir(Responsavel r, Montadora m) {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "DELETE FROM Mont_Resp WHERE montadora_id = ? and responsavel_id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, m.getId());
            p.setInt(2, r.getId());
            p.executeUpdate();

            System.out.println("_______________________________________________");
            System.out.println("Dados da tabela Mont_Resp excluido com sucesso!");
            System.out.println("_______________________________________________");

        } catch (Exception e) {
            
            e.printStackTrace();

        }

        return null;
    }
    
}
