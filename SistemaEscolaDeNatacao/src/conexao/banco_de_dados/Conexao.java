/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My Space
 */
public class Conexao {
    private static String usuario = "root";
    private static String senha = "";
    private static String banco = "aquaticus";
    private static String ip = "localhost";
    private static String driver = "com.mysql.jdbc.Driver";
    
    public Connection getConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://" + ip + "/" + banco + "", usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
