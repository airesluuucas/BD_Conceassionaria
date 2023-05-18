package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import DAO.ResponsavelDAO;
import Model.Responsavel;

public class DAOResponsavelTeste {
    
    public static void main(String[] args) {
        
        //criarTabela();
        //inserir();
        //listarComRetorno();
        //listar();
        //buscar();
        //excluir();
        //alterar();


    }

    public static void criarTabela() {

        try {
            
            String sql = "CREATE TABLE Responsavel ("
            +"id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
            +"nome VARCHAR(50) NOT NULL,"
            +"passe INT UNSIGNED NOT NULL,"
            +"PRIMARY KEY (id),"
            +"UNIQUE KEY(passe)"
            +")";

            Connection c = FabricaConexao.getConexao();
            Statement s = c.createStatement();
            s.execute(sql);
            System.out.println("_______________________________________");
            System.out.println("Tabela responsavel criada com sucesso!");
            System.out.println("_______________________________________");

            c.close();
            s.close();

        } catch (Exception e) {
            
            e.printStackTrace();

        }

    }

    public static void inserir() {

        ResponsavelDAO dao = new ResponsavelDAO();
        Responsavel r = new Responsavel("Ana Maria", 2317);
        dao.inserir(r);

    }

    public static void listar() {
        
        ResponsavelDAO dao = new ResponsavelDAO();

        dao.listar();

    }

    public static void listarComRetorno() {
        
        ResponsavelDAO dao = new ResponsavelDAO();
        List<Responsavel> lr = dao.listarComRetorno();

        for (Responsavel r : lr) {

            System.out.println(r.toString());

        }

    }

    public static void buscar() {

        ResponsavelDAO dao = new ResponsavelDAO();
        Responsavel responsavel = dao.buscar("Manoel Gomez");
        System.out.println("_____________________________________________________________");
        System.out.println("Dados da tabela responsavel!");
        System.out.println("_____________________________________________________________");
        System.out.println(responsavel.toString());

    }

    public static void excluir() {

        ResponsavelDAO dao = new ResponsavelDAO();
        Responsavel r = dao.buscar("Ana Maria");
        dao.excluir(r);

    }

    public static void alterar() {

        ResponsavelDAO dao = new ResponsavelDAO();
        Responsavel r = dao.buscar("Jussara MAria");
        r.setNome("Jussara Maria");
        r.setPasse(3232);
        dao.alterar(r);

    }

}
