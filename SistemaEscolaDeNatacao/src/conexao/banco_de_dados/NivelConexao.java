/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.banco_de_dados;

import entidades.Nivel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author My Space
 */
public class NivelConexao {
    private static Connection connection;
    
    public static void InsereNivel(Nivel nivel) throws SQLException{
        connection = new Conexao().getConexao();
        String sql = "insert into nivel" + "(nome,descricao,cor)"
                + "values (?,?,?)";
        
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nivel.getNome());
            stmt.setString(2, nivel.getDescricao());
            stmt.setFloat(3, nivel.getCor());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Salvando no Banco...",INFORMATION_MESSAGE );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
    
    public static ArrayList<Nivel> BuscaNivel() throws SQLException{
        connection = new Conexao().getConexao();
        String sql = "select * from nivel";
        ArrayList<Nivel> lista_nivel = new ArrayList<Nivel>();
        try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Nivel nivel = new Nivel();
            nivel.setIdNivel( rs.getInt("id"));
            nivel.setNome( rs.getString("nome"));
            nivel.setDescricao(rs.getString("descricao"));
            nivel.setCor( rs.getFloat("cor"));
            
            lista_nivel.add(nivel);
        }
        
        rs.close();
        stmt.close();
        return lista_nivel;
        }catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
