package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import DAO.CarroDAO;
import DAO.MarcaDAO;
import DAO.MontadoraDAO;
import Model.Carro;
import Model.Marca;
import Model.Montadora;

public class DAOCarroTeste {
    
    public static void main(String[] args) {
        
        //criarTabela();
        //inserir();
        //listar();
        //listarCRetorno();
        //buscar();           
        //excluir();
        alterar();

    }

    public static void criarTabela() {
        
        try {
            
            String sql = "CREATE TABLE Carro ("
                +"id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                +"modelo VARCHAR(45) NOT NULL,"
                +"cor VARCHAR(35) NOT NULL,"
                +"valor DECIMAL(6,2) UNSIGNED NOT NULL,"
                +"ano INT UNSIGNED NOT NULL,"
                +"montadora_id int UNSIGNED NOT NULL,"
                +"marca_id int UNSIGNED NOT NULL,"
                +"PRIMARY KEY(id),"
                +"FOREIGN KEY(montadora_id) REFERENCES Montadora(id),"
                +"FOREIGN KEY(marca_id) REFERENCES Marca(id)"
                +")";

            Connection c = FabricaConexao.getConexao();
            Statement s = c.createStatement();
            s.execute(sql);

            System.out.println("_______________________________________");
            System.out.println("Tabela criada com sucesso!");
            System.out.println("_______________________________________");

            c.close();
            s.close();

        } catch (Exception e) {
            
            e.printStackTrace();

        }

    }

    public static void inserir(){

        CarroDAO dao = new CarroDAO();
        MontadoraDAO dao2 = new MontadoraDAO();
        Montadora montadora = dao2.buscar("Fc Cars");
        MarcaDAO dao3 = new MarcaDAO();
        Marca marca = dao3.buscar("Kia");

        Carro carro = new Carro(2,"Cerato", "Vermelho", 30.95, 2010, montadora.getId(), marca.getId());
        dao.inserir(carro);

    }

    public static void listar() {

        CarroDAO dao = new CarroDAO();

        dao.listar();

    }

    public static void listarCRetorno() {
        
        CarroDAO dao = new CarroDAO();
        List<Carro> c = dao.listarCRetorno();
        System.out.println("_____________________________________________________________");
        System.out.println("Dados da tabela carros!");
        System.out.println("_____________________________________________________________");

        for (Carro carro : c) {
            System.out.println(carro.toString());
            System.out.println("_____________________________________________________________");
        }

    }

    public static void buscar() {

        CarroDAO dao = new CarroDAO();
        Carro carro = dao.buscar("BMW X6");

        System.out.println("_____________________________________________________________");
        System.out.println("Buscar carro!");
        System.out.println("_____________________________________________________________");
        System.out.println(carro.toString());
        System.out.println("_____________________________________________________________");

    }

    public static void excluir() {

        CarroDAO dao = new CarroDAO();
        Carro carro = dao.buscar("Cerato");

        dao.excluir(carro);

    }

    public static void alterar() {

        CarroDAO dao = new CarroDAO();
        Carro c = dao.buscar("Cerato");
        c.setModelo("Cerato");
        c.setCor("Vermelho");
        c.setValor(20.00);
        c.setAno(2010);
        dao.alterar(c);

    }

}