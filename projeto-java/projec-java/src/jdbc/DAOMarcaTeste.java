package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.MarcaDAO;
import Model.Marca;

public class DAOMarcaTeste {
    
    public static void main(String[] args) {
        //criarTabela();
        //inserir();
        //listar();
        //buscar();
        //alterar();
        //excluir();
 

    }


    public static void criarTabela() {
        
        

        try {

            Connection connection = FabricaConexao.getConexao();
            String sql = "CREATE TABLE Marca ("
            + "id INT UNSIGNED NOT NULL  AUTO_INCREMENT,"
            + "nome VARCHAR(50) NOT NULL,"
            + "sede VARCHAR(50) NOT NULL,"
            + "valor DECIMAL(9,2) NOT NULL,"
            + "PRIMARY KEY(id),"
            + "UNIQUE KEY(nome)"
            + ")";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
    
            System.out.println("Tabela criada com sucesso!");
            connection.close();
            stmt.close();

        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
    public static void inserir() {

        MarcaDAO dao = new MarcaDAO();
        Marca m = new Marca("aaa", "aaaaa", 66.00);
        dao.incluir(m);

    }

    public static void listar() {

        MarcaDAO dao = new MarcaDAO();
        List<Marca> marca;
        marca = dao.mostrar();
        
        System.out.println("____________ MARCAS____________");
        for ( Marca m : marca) {
            System.out.println(m.toString());
        }
        System.out.println("_______________________________");

    }

    public static void buscar() {

        MarcaDAO dao = new MarcaDAO();
        Marca marca;
        marca = dao.buscar("Kia");

        System.out.println(marca.toString());

    }

    public static void alterar() {

        MarcaDAO dao = new MarcaDAO();
        Marca m = new Marca();

        m = dao.buscar("Kia");
        m.setNome("Kia");
        m.setSede("Coreia do Sul");
        m.setValor(6612.00);

        dao.alterar(m);

    }

    public static void excluir() {

        MarcaDAO dao = new MarcaDAO();
        Marca m;

        m = dao.buscar("aaa");
        dao.excluir(m);



    }
}
