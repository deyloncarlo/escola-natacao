/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.banco_de_dados;

import entidades.Contato;
import entidades.Responsavel;
import entidades.Turma;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author My Space
 */
public class ResponsavelConexao {

    private static Connection connection;

    public static void InsereResponsavel(Responsavel responsavel) throws SQLException {
        connection = new Conexao().getConexao();
        String sql = "insert into Responsavel" + "(nome,rg,data_nascimento,estado_civil,rua,numero,"
                + "bairro,cidade,cep,estado,profissao,escolaridade,facebook,email,complemento)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, responsavel.getNome());
            stmt.setString(2, responsavel.getRG());
            stmt.setDate(3, new Date(responsavel.getDataNascimento().getTimeInMillis()));
            stmt.setString(4, responsavel.getEstadoCivil());
            stmt.setString(5, responsavel.getRua());
            stmt.setString(6, responsavel.getNumero());
            stmt.setString(7, responsavel.getBairro());
            stmt.setString(8, responsavel.getCidade());
            stmt.setString(9, responsavel.getCep());
            stmt.setString(10, responsavel.getEstado());
            stmt.setString(11, responsavel.getProfissao());
            stmt.setString(12, responsavel.getEscolaridade());
            stmt.setString(13, responsavel.getFacebook());
            stmt.setString(14, responsavel.getEmail());
            stmt.setString(15, responsavel.getComplemento());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }

    public static void InsereContato(ArrayList<Contato> lista_contato) throws SQLException {

        connection = new Conexao().getConexao();
        String sql = "insert into contato" + "(nome,telefone,whatsapp,operadora,responsavel_id)"
                + "values (?,?,?,?,?)";

        PreparedStatement stmt;

        try {
            for (int indice = 0; indice < lista_contato.size(); indice++) {

                stmt = connection.prepareStatement(sql);
                stmt.setString(1, lista_contato.get(indice).getNome());
                stmt.setString(2, lista_contato.get(indice).getTelefone());
                stmt.setBoolean(3, lista_contato.get(indice).isIsWhatsapp());
                stmt.setString(4, lista_contato.get(indice).getOperadora());
                stmt.setInt(5, lista_contato.get(indice).getIdResponsavel());

                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }

    public static Responsavel BuscaResponsavelPeloRG(String rgResponsavel) throws SQLException {
        connection = new Conexao().getConexao();
        String sql = "select id from responsavel where rg = ?";
        ArrayList<Turma> lista_turma = new ArrayList<Turma>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, rgResponsavel);
            ResultSet rs = stmt.executeQuery();
            Responsavel responsavel = new Responsavel();
            while (rs.next()) {
                responsavel.setIdResponsavel(rs.getInt("id"));
            }
            rs.close();
            stmt.close();
            return responsavel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
