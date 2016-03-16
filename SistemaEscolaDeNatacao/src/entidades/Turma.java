/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author My Space
 */
public class Turma {
    private int idTurma;
    private String nome;
    private Time horarioInicio;
    private Time horarioFim;
    private String primairoDia;
    private String segundoDia;
    
    public int getIdTurma(){
        return idTurma;
    }
    
    public void setIdTurma(int idTurma){
        this.idTurma = idTurma;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getPrimairoDia() {
        return primairoDia;
    }

    public void setPrimairoDia(String primairoDia) {
        this.primairoDia = primairoDia;
    }

    public String getSegundoDia() {
        return segundoDia;
    }

    public void setSegundoDia(String segundoDia) {
        this.segundoDia = segundoDia;
    }
    
    
}
