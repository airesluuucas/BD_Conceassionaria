package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;
    
    public void incluir(String sql, Object... atributos){

        try {
            PreparedStatement preparedStatement = getConexao()
            .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(preparedStatement, atributos);

            if(preparedStatement.executeUpdate() > 0 ){
               ResultSet resultSet = preparedStatement.getGeneratedKeys();

                 resultSet.next();
                 resultSet.getInt(1);
              
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    public void close(){
        try {
            getConexao().close();
        } catch (Exception e) {
            
        } finally {
            conexao = null;
        }
    }

    private void adicionarAtributos(PreparedStatement statement, Object[] atributos) throws SQLException{

        int indice = 1;
        for (Object atributo : atributos) {
            if(atributo instanceof String){
                statement.setString(indice,(String) atributo);
            }else if(atributo instanceof Integer){
                statement.setInt(indice, (Integer) atributo);
            }else if(atributo instanceof Double){
                statement.setDouble(indice, (Double) atributo);
            }
            indice++;
        }

    }
    private Connection getConexao(){
        try {
            if(conexao != null && !conexao.isClosed()){
                return conexao;

            }
        } catch (SQLException e) {

        }
        conexao = FabricaConexao.getConexao();
        return conexao;
    }
}