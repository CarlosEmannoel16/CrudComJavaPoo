
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionDb {
    
    
    public void ConnectionDb(){
        this.getConexao();
    }
    
    public Connection getConexao(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoFinal","root","1234");
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
         }
        
         return conexao;
        }
    
       
    
}
