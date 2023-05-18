package jdbc;

import java.sql.SQLException;

import DAO.EstadoDAO;
import Model.Estado;

public class DAOEstadoTeste {
        public static void main(String[] args) throws SQLException{

            //inserir();
            listar();
            //pesquisar();
            //excluir();
            //alterar();
            
        }

        // Listar todos os estados 
        public static void listar(){

            EstadoDAO estadoDAO = new EstadoDAO();
            
            for (Estado e : estadoDAO.listar()) {
                System.out.println(e.toString());
            }
        }
        //
        public static void inserir() {
            EstadoDAO estadoDAO = new EstadoDAO();
            Estado estado = new Estado("AAAA", "GG", "Norte", 4.44);

            estadoDAO.inserir(estado);
        }
        //
        public static void excluir() {
            EstadoDAO estadoDAO = new EstadoDAO();

            estadoDAO.excluir("GG");
        }

        public static void pesquisar(){
            EstadoDAO estadoDAO = new EstadoDAO();
            Estado e = estadoDAO.buscar("CC");

            System.out.println(e.toString());
        }

        public static void alterar(){

            EstadoDAO estadoDAO = new EstadoDAO();

            Estado e = estadoDAO.buscar("CC");

            e.setNome("Rio de Janeiro");
            e.setRegiao("Sudeste");
            e.setSigla("RJ");
            
            estadoDAO.alterar(e);

        }
}