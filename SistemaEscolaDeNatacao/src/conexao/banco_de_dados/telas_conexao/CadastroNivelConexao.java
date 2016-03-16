/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.banco_de_dados.telas_conexao;

import conexao.banco_de_dados.Conexao;
import entidades.Nivel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author My Space
 */
public class CadastroNivelConexao {
    private static Connection connection;
    
    public static boolean isNivelExiste(Nivel nivel) throws SQLException{
        connection = new Conexao().getConexao();
        String sql = "select cor,nome from nivel where cor = ? or nome = ?";
        ArrayList<Nivel> lista_nivel = new ArrayList<Nivel>();
        try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setFloat(1,nivel.getCor());
        stmt.setString(2,nivel.getNome());
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Nivel nivelEncontrado = new Nivel();
            nivelEncontrado.setNome( rs.getString("nome"));
            nivelEncontrado.setCor( rs.getFloat("cor"));
            
            lista_nivel.add(nivel);
        }
        
        rs.close();
        stmt.close();
        
        return lista_nivel.isEmpty();
        }catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
