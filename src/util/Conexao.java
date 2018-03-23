package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
    private static Connection conexao;
    
    public static Connection getConexao(){
        
        try {
            if(conexao == null || conexao.isClosed())
            	conexao = conectar();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return conexao;
    }
    
    private static Connection conectar() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://fernandolimati.com.br:8080/clube201801","usuariodb","F#240924s");
    
        }catch (ClassNotFoundException e) {
            System.out.println("Não foi encontrado a biblioteca postgres! ");
                
        }catch (SQLException e){
            System.out.print("Banco/Usuario/Senha estaão erradas");
        }
        return null;
    }
}