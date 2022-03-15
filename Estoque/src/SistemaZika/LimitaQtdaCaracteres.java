/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Leonardo Nunes
 */
public class LimitaQtdaCaracteres extends PlainDocument {
    private int tamanhoMaximo;

    public LimitaQtdaCaracteres(int maxLen){
        super();
        tamanhoMaximo = maxLen;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if(str == null) return;
         //aceita qualquer numero de caracteres
        if(tamanhoMaximo <= 0){
            super.insertString(offset, str, attr);
            return;
        }
        int iLen = (getLength()+str.length());
        if(iLen <= tamanhoMaximo){
            super.insertString(offset, str, attr); //aceita a str
        }else{
            if(getLength() == tamanhoMaximo) return; // nada a fazer
            String novaStr = str.substring(0, (tamanhoMaximo - getLength()));
            super.insertString(offset, novaStr, attr);
        }
    }

}