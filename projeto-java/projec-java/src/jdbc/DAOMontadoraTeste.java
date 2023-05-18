package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.CidadeDAO;
import DAO.MontadoraDAO;
import Model.Cidade;
import Model.Montadora;

public class DAOMontadoraTeste {
    
    public static void main(String[] args) {
        
        //criarTabela();
        //inserir();
        //listar();
        //listarMont();
        //buscar();
        //excluir();
        alterar();

    }

    public static void criarTabela() {

        try {
            
            String sql = "CREATE TABLE Montadora ("
            +"id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
            +"nome VARCHAR(50) NOT NULL,"
            +"cidade_id INT UNSIGNED NOT NULL,"
            +"PRIMARY KEY(id),"
            +"FOREIGN KEY(cidade_id) REFERENCES Cidade (id)"
            +")";

            Connection c = FabricaConexao.getConexao();
            Statement s = c.createStatement();
            s.execute(sql);

            System.out.println("_______________________________________");
            System.out.println("Tabela criada com sucesso!");
            System.out.println("_______________________________________");

            s.close(); 
            c.close();

        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    public static void inserir() {

        MontadoraDAO dao = new MontadoraDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade c = cidadeDAO.buscar("Belford Rocho");
        Montadora m = new Montadora("Fc CarsSSS", c.getId());
        dao.inserir(m);

    }
    
    public static void listar() {

        MontadoraDAO dao = new MontadoraDAO();

        dao.listar();

    }

    public static void listarMont() {

        MontadoraDAO dao = new MontadoraDAO();
        List<Montadora> mont = new ArrayList<>();

        mont = dao.listarMont();
        System.out.println(mont);

    }
    public static void buscar() {

        MontadoraDAO dao = new MontadoraDAO();
        Montadora m = new Montadora();

        m = dao.buscar("Fc Cars");

        System.out.println(m.toString());

    }

    public static void excluir() {

        MontadoraDAO dao = new MontadoraDAO();
        Montadora m = new Montadora();

        m = dao.buscar("Fc Cars");
        dao.excluir(m);

    }

    public static void alterar() {

        MontadoraDAO dao = new MontadoraDAO();
        Montadora montadora = new Montadora();

        montadora = dao.buscar("Fc CarsSSS");
        montadora.setNome("Fc Cars");
        dao.alterar(montadora);

    }

}