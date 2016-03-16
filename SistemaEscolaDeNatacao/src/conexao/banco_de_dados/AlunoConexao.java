/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.banco_de_dados;

import entidades.Aluno;
import entidades.AnamneseAluno;
import entidades.AntropometriaAluno;
import entidades.Contato;
import entidades.Endereco;
import entidades.ObjetivoAluno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author My Space
 */
public class AlunoConexao {

    private static Connection connection;

    public static void InsereAluno(Aluno aluno) throws SQLException {
        connection = new Conexao().getConexao();

        String sql = "insert into Aluno" + "(nome,rg,data_nascimento,"
                + "estado_civil,escolaridade,aluno_governo,natacao,hidro,motivo,"
                + "profissao,facebook,email,nivel_id,responsavel_id,turma_id)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getRG());
            stmt.setDate(3, new Date(aluno.getDataNascimento().getTimeInMillis()));
            stmt.setString(4, aluno.getEstadoCivil());
            stmt.setString(5, aluno.getEscolaridade());
            stmt.setBoolean(6, aluno.isIsAlunoGoverno());
            stmt.setBoolean(7, aluno.isIsNatacao());
            stmt.setBoolean(8, aluno.isIsHidroginastica());
            stmt.setString(9, aluno.getMotivo());
            stmt.setString(10, aluno.getProfissao());
            stmt.setString(11, aluno.getFacebook());
            stmt.setString(12, aluno.getEmail());
            stmt.setInt(13, aluno.getIdNivel());
            stmt.setInt(14, aluno.getIdResponsavel());
            stmt.setInt(15, aluno.getIdTurma());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }

    public static void InsereEndereco(ArrayList<Endereco> lista_endereco, int idAluno) throws SQLException {

        connection = new Conexao().getConexao();
        String sql = "insert into Endereco" + "(rua,numero,bairro,cep,estado,cidade,"
                + "complemento,aluno_id)"
                + "values (?,?,?,?,?,?,?,?)";

        PreparedStatement stmt;

        try {
            for (int indice = 0; indice < lista_endereco.size(); indice++) {

                stmt = connection.prepareStatement(sql);
                stmt.setString(1, lista_endereco.get(indice).getRua());
                stmt.setString(2, lista_endereco.get(indice).getNumero());
                stmt.setString(3, lista_endereco.get(indice).getBairro());
                stmt.setString(4, lista_endereco.get(indice).getCep());
                stmt.setString(5, lista_endereco.get(indice).getEstado());
                stmt.setString(6, lista_endereco.get(indice).getCidade());
                stmt.setString(7, lista_endereco.get(indice).getComplemento());
                stmt.setInt(8, idAluno);

                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }

    public static void InsereContato(ArrayList<Contato> lista_contato, int idAluno) throws SQLException {

        connection = new Conexao().getConexao();
        String sql = "insert into contato" + "(nome,telefone,whatsapp,operadora,aluno_id)"
                + "values (?,?,?,?,?)";

        PreparedStatement stmt;

        try {
            for (int indice = 0; indice < lista_contato.size(); indice++) {

                stmt = connection.prepareStatement(sql);
                stmt.setString(1, lista_contato.get(indice).getNome());
                stmt.setString(2, lista_contato.get(indice).getTelefone());
                stmt.setBoolean(3, lista_contato.get(indice).isIsWhatsapp());
                stmt.setString(4, lista_contato.get(indice).getOperadora());
                stmt.setInt(5, idAluno);

                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }

    public static void InsereObjetivo(int idObjetivo, int idAluno) throws SQLException {
        connection = new Conexao().getConexao();
        String sql = "insert into objetivo_aluno" + "(objetivo_id,aluno_id)"
                + "values (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idObjetivo);
            stmt.setInt(2, idAluno);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }

    public static void InsereAnamnese(AnamneseAluno anamneseAluno, int idAluno) throws SQLException {
        connection = new Conexao().getConexao();

        String sql = "insert into anamnese_aluno" + "(aluno_id,pergunta1,pergunta2,"
                + "pergunta3,pergunta4,pergunta5,pergunta6,pergunta7,pergunta8,pergunta9,"
                + "pergunta10,pergunta11,pergunta12,pergunta13,pergunta14,pergunta15)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            stmt.setBoolean(2, anamneseAluno.isPergunta1());
            stmt.setBoolean(3, anamneseAluno.isPergunta2());
            stmt.setBoolean(4, anamneseAluno.isPergunta3());
            stmt.setBoolean(5, anamneseAluno.isPergunta4());
            stmt.setBoolean(6, anamneseAluno.isPergunta5());
            stmt.setBoolean(7, anamneseAluno.isPergunta6());
            stmt.setBoolean(8, anamneseAluno.isPergunta7());
            stmt.setBoolean(9, anamneseAluno.isPergunta8());
            stmt.setBoolean(10, anamneseAluno.isPergunta9());
            stmt.setBoolean(11, anamneseAluno.isPergunta10());
            stmt.setBoolean(12, anamneseAluno.isPergunta11());
            stmt.setBoolean(13, anamneseAluno.isPergunta12());
            stmt.setBoolean(14, anamneseAluno.isPergunta13());
            stmt.setBoolean(15, anamneseAluno.isPergunta14());
            stmt.setBoolean(16, anamneseAluno.isPergunta15());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
    
    public static void InsereAntropometria(AntropometriaAluno antropomeriaAluno, int idAluno) throws SQLException{
        connection = new Conexao().getConexao();

        String sql = "insert into antropometria" + "(aluno_id,freq_cardiaca,imc,icq,p_arterial,"
                + "altura,quadril,classificacao_1,classificacao_2,classificacao_3)"
                + "values (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            stmt.setFloat(2, antropomeriaAluno.getFrequenciaCardiaca());
            stmt.setFloat(3, antropomeriaAluno.getIMC());
            stmt.setFloat(4, antropomeriaAluno.getICQ());
            stmt.setFloat(5, antropomeriaAluno.getPressaoArterial());
            stmt.setFloat(6, antropomeriaAluno.getAltura());
            stmt.setFloat(7, antropomeriaAluno.getQuadril());
            stmt.setString(8, antropomeriaAluno.getClassificacao1());
            stmt.setString(9, antropomeriaAluno.getClassificacao2());
            stmt.setString(10, antropomeriaAluno.getClassificacao3());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
