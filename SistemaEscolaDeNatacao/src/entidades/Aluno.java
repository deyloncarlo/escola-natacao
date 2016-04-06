/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.Calendar;
import javafx.scene.text.Text;

/**
 *
 * @author My Space
 */
public class Aluno {
    private int idAluno;
    private boolean isNatacao;
    private boolean isHidroginastica;
    private boolean isAlunoGoverno;
    private String nome;
    private Calendar dataNascimento;
    private String RG;
    private String estadoCivil;
    private String profissao;
    private String escolaridade;
    private String email;
    private String facebook;
    private String motivo;
    private int idResponsavel;
    private int idNivel;
    private int idTurma;

    public int getIdAluno(){
        return idAluno;
    }
    
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    
    public boolean isNatacao() {
        return isNatacao;
    }

    public void setIsNatacao(boolean isNatacao) {
        this.isNatacao = isNatacao;
    }

    public boolean isHidroginastica() {
        return isHidroginastica;
    }

    public void setIsHidroginastica(boolean isHidroginastica) {
        this.isHidroginastica = isHidroginastica;
    }

    public boolean isAlunoGoverno() {
        return isAlunoGoverno;
    }

    public void setIsAlunoGoverno(boolean isAlunoGoverno) {
        this.isAlunoGoverno = isAlunoGoverno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
}
