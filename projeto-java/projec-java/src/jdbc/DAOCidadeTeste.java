package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.CidadeDAO;
import DAO.EstadoDAO;
import Model.Cidade;
import Model.Estado;

public class DAOCidadeTeste {
    
     public static void main(String[] args) {
        
      //criarTabela();
      //inserir();
      //listar();
      //buscar();           
      //excluir();
      //alterar();

     }

    public static void criarTabela() {

        try {

            Connection c = FabricaConexao.getConexao();
            
            String create = "CREATE TABLE Cidade ("
                +"id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                +"nome VARCHAR(50) NOT NULL,"
                +"estado_id INT UNSIGNED NOT NULL,"
                +"PRIMARY KEY (id),"
                +"UNIQUE KEY (nome),"
                +"FOREIGN KEY(estado_id) REFERENCES Estado (id)"
                +")";

            Statement s = c.createStatement();
            s.execute(create);
            
            System.out.println("_______________________________________");
            System.out.println("Tabela criada com sucesso!");
            System.out.println("_______________________________________");

            c.close();
            s.close();

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    public static void inserir() {
        EstadoDAO e = new EstadoDAO();
        Estado est = e.buscar("AM");
        Cidade c = new Cidade( "Mans", est.getId());
        CidadeDAO dao = new CidadeDAO();

        dao.inserir(c);

    }
    
    public static void listar() {
        CidadeDAO c = new CidadeDAO();

        c.listar();

    }

    public static void buscar() {

        CidadeDAO dao = new CidadeDAO();
        Cidade c;

        c = dao.buscar("Manaus");
        System.out.println("_______________________________________");
        System.out.println("____________Buscar_____________________");
        System.out.println(c.toString());
        System.out.println("_______________________________________");

    }

    public static void excluir() {

        CidadeDAO dao = new CidadeDAO();
        Cidade c;

        c = dao.buscar("Manaus");
        System.out.println("_______________Dados___________________");
        System.out.println(c.toString());
        System.out.println("_______________________________________");
        dao.excluir(c);

    }

    public static void alterar() {

        CidadeDAO dao = new CidadeDAO();
        Cidade c = new Cidade();

        c = dao.buscar("Mans");
        c.setNome("Manaus");
        dao.alterar(c);
    }
}
