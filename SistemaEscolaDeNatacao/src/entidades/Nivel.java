/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author My Space
 */
public class Nivel {
    private int idNivel;
    private String nome;
    private String descricao;
    private float cor;

    public int getIdNivel(){
        return idNivel;
    }
    
    public void setIdNivel(int idNivel){
        this.idNivel = idNivel;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCor() {
        return cor;
    }

    public void setCor(float cor) {
        this.cor = cor;
    }
}
