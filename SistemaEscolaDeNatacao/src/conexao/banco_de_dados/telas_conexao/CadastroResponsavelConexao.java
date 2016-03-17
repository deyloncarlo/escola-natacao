/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.banco_de_dados.telas_conexao;

import conexao.banco_de_dados.Conexao;
import entidades.Responsavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author My Space
 */
public class CadastroResponsavelConexao {

    private static Connection connection;

    public static boolean isResponsavelExiste(String rgResponsavel) throws SQLException {
        connection = new Conexao().getConexao();
        String sql = "select * from responsavel where rg = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, rgResponsavel);
            
            ResultSet rs = stmt.executeQuery();
            Responsavel responsavel = null;
            while(rs.next()){
                responsavel = new Responsavel();
                responsavel.setRG(rs.getString("rg"));
            }          
            
            rs.close();
            stmt.close();

            return responsavel != null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
