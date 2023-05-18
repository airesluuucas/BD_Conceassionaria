package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import DAO.MontadoraDAO;
import DAO.MontadoraResponsavelDAO;
import DAO.ResponsavelDAO;
import Model.Montadora;
import Model.MontadoraResponsavel;
import Model.Responsavel;

public class DAOMontadoraResponsavelTeste {
    
    public static void main(String[] args) {
        

        //criarTabela();
        //inserir();
        //listarComRetorno();
        //listar();
        //buscar();
        //excluir();
        alterar();
        
        
    }

    public static void criarTabela() {

        try {
            
            Connection c = FabricaConexao.getConexao();
            String sql = "CREATE TABLE Mont_Resp("
                +"montadora_id INT UNSIGNED NOT NULL,"
                +"responsavel_id INT UNSIGNED NOT NULL,"
                +"FOREIGN KEY(montadora_id) REFERENCES Montadora(id),"
                +"FOREIGN KEY(responsavel_id) REFERENCES Responsavel(id)"
                +")";
            
                Statement s = c.createStatement();
                s.execute(sql);
                System.out.println("________________________________________________");
                System.out.println("Tabela Montadora_Responsavel criada com sucesso!");
                System.out.println("________________________________________________");
    
                c.close();
                s.close();

        } catch (Exception e) {
           
            e.printStackTrace();

        }

    }

    public static void inserir() {

        ResponsavelDAO rDAO = new ResponsavelDAO();
        Responsavel r = rDAO.buscar("Manoel Gomez");

        MontadoraDAO mDAO = new MontadoraDAO();
        Montadora m = mDAO.buscar("Fc Cars");
        
        MontadoraResponsavelDAO mr = new MontadoraResponsavelDAO();

        mr.inserir(r,m);
        
    }

    public static void listarComRetorno() {

        MontadoraResponsavelDAO dao = new MontadoraResponsavelDAO();
        List<MontadoraResponsavel> mr = dao.listarComRetorno();

        for (MontadoraResponsavel m : mr) {
            System.out.println(m.toString());
        }

    }

    public static void listar() {

        MontadoraResponsavelDAO dao = new MontadoraResponsavelDAO();

        dao.listar();

    }

    public static void buscar() {

        ResponsavelDAO rDAO = new ResponsavelDAO();
        Responsavel r = rDAO.buscar("Manoel Gomez");

        MontadoraDAO mDAO = new MontadoraDAO();
        Montadora m = mDAO.buscar("Fc Cars");

        MontadoraResponsavelDAO dao = new MontadoraResponsavelDAO();
        MontadoraResponsavel mr = dao.buscar(r,m);

        System.out.println(mr.toString());

    }

    public static void excluir() {

        ResponsavelDAO rDAO = new ResponsavelDAO();
        Responsavel r = rDAO.buscar("Manoel Gomez");

        MontadoraDAO mDAO = new MontadoraDAO();
        Montadora m = mDAO.buscar("Fc Cars");

        MontadoraResponsavelDAO dao = new MontadoraResponsavelDAO();
        dao.excluir(r,m);
        
    }

}