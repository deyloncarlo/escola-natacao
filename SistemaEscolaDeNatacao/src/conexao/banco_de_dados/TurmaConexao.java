/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.banco_de_dados;

import entidades.Nivel;
import entidades.Responsavel;
import entidades.Turma;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

/**
 *
 * @author My Space
 */
public class TurmaConexao {
    private static Connection connection;
    
    public static void InsereTurma(Turma turma) throws SQLException{
        connection = new Conexao().getConexao();
        String sql = "insert into Turma" + "(nome,horario_inicio,horario_fim,primeiro_dia,segundo_dia)"
                + "values (?,?,?,?,?)";
        
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, turma.getNome());
            stmt.setTime(2, turma.getHorarioInicio());
            stmt.setTime(3, turma.getHorarioFim());
            stmt.setString(4, turma.getPrimairoDia());
            stmt.setString(5, turma.getSegundoDia());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Turma cadastrada com sucesso!","Cadastrando Turma...",INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
    
    public static ArrayList<Turma> BuscaTurma() throws SQLException{
        connection = new Conexao().getConexao();
        String sql = "select * from turma";
        ArrayList<Turma> lista_turma = new ArrayList<Turma>();
        try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Turma turma = new Turma();
            turma.setIdTurma(rs.getInt("id"));
            turma.setNome( rs.getString("nome"));
            turma.setHorarioInicio(rs.getTime("horario_inicio"));
            turma.setHorarioFim(rs.getTime("horario_fim"));
            turma.setPrimairoDia(rs.getString("primeiro_dia"));
            turma.setSegundoDia(rs.getString("segundo_dia"));
            
            lista_turma.add(turma);
        }
        
        rs.close();
        stmt.close();
        return lista_turma;
        }catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
    
    public static void AlteraTurma(Turma turma) throws SQLException{
        connection = new Conexao().getConexao();
        String sql = "update Turma set nome = ?, horario_inicio = ?,horario_fim = ?, primeiro_dia = ?, segundo_dia = ?"
                + " where id = ?";
        
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, turma.getNome());
            stmt.setTime(2, turma.getHorarioInicio());
            stmt.setTime(3, turma.getHorarioFim());
            stmt.setString(4, turma.getPrimairoDia());
            stmt.setString(5, turma.getSegundoDia());
            stmt.setInt(6, turma.getIdTurma());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Turma alterada com sucesso!","Alterando Turma...",INFORMATION_MESSAGE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
