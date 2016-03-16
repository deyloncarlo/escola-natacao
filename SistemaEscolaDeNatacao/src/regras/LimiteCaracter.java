/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras;

import static java.lang.reflect.Array.getLength;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author My Space
 */
public class LimiteCaracter extends PlainDocument{
    private int quantidadeMaxima;
    
    public LimiteCaracter(int quantidadeMaxima){
       super();
       
       if(quantidadeMaxima <= 0){
           throw new IllegalArgumentException("Defina a quantidade de caracteres!");
       }
       this.quantidadeMaxima = quantidadeMaxima;
    }
    
    @Override
    public void insertString(int offset,String str, AttributeSet attr) throws BadLocationException{
        
        if(str == null || getLength() == this.quantidadeMaxima){
            return;
        }
        
        int quantidadeCaracter = (getLength() + str.length());
        
        if(quantidadeCaracter <= this.quantidadeMaxima){
            super.insertString(offset, str.replaceAll("^[a-z]^[A-Z]^[0-9]^['!#$%&'*+/=?]^[_`{|}~-]",""), attr);
            return;
        }
        
        String novaString = str.substring(0,getLength() - this.quantidadeMaxima);
        super.insertString(offset, novaString, attr);
    }
}
