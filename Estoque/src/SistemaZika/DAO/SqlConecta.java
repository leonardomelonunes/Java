/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Nunes
 */
public class SqlConecta {
  public static Connection getConnection(){
      try{
          return DriverManager.getConnection("jdbc:mysql://localhost/bancosistemazikav", "root", "");
          
      }catch(SQLException error){
          //throw new RuntimeException("error conexão");
          JOptionPane.showMessageDialog(null, "ERRO BANCAO" + error);
          
      }
      return null;
  }  
    
}
