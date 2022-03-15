/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


/**
 *
 * @author Leonardo Nunes
 */
public class Mascara {

	//exemplo de uso.....
    public static DefaultFormatterFactory setMaskData(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("####/##/##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }

    public static DefaultFormatterFactory setMaskDataHora(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("##/##/#### ##:##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }
	
    public static void setLog(String log){
        try{
            //abre/cria o arquivo de log
            String nomeArq = new SimpleDateFormat("MMMyyyy").format(new Date())+".uniplac";
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArq, true));
            //grava no arquivo
            bw.write("\n\n"+new SimpleDateFormat("[dd/MM/yyy HH:mm] ").format(new Date())+log);
            bw.close();
        }catch(Exception e){}
    }
    
    public static DefaultFormatterFactory setMaskCNPJ(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("########/##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
        
        
    }
    public static DefaultFormatterFactory setMaskCPF(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }
	public static DefaultFormatterFactory setMaskTelFixo(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("(##)####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }

        public static DefaultFormatterFactory setMaskCelular(){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter("(##)#####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException e){
            setLog("Funcoes : "+e.getMessage());
        }
        return new DefaultFormatterFactory(mask,mask);
    }
}