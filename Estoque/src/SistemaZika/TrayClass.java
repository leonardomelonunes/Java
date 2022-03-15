package SistemaZika;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TrayClass{
   static TrayIcon trayIcon;

/**
*
* @author Leonardo
*/
    public TrayClass() {
       
       show();
   }
      public static void show(){
      if (!SystemTray.isSupported()){
      System.exit(0);
      }
      trayIcon =new TrayIcon(createIcon("/SistemaZika/users2.png","Icon"));
      trayIcon.setToolTip("SistemaZika 2019 SI");
      final SystemTray tray =SystemTray.getSystemTray();
      
      final PopupMenu menu = new PopupMenu();
      
      MenuItem abrirAplicacao = new MenuItem("Abrir Aplicação");
      MenuItem encerrar = new MenuItem("Encerrar");
      MenuItem sobre = new MenuItem("Sobre");
      
      menu.add(abrirAplicacao);
      
      menu.add(encerrar);
      menu.add(sobre);
      
      encerrar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
               System.exit(0);
          }
      });
      
      
 sobre.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"SistemaZika 2019 \n Desenvolvido na materia de desenvolvimento de sistemas 3ºsem de Sistemas de Informação UNIPLAC LAGES. Autor Leonardo Nunes");
              
          }
      });
 
 abrirAplicacao.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
          
        
          
        JFrame app = new Aplicacao();
        app.setVisible(true);
        tray.remove(trayIcon);
          }
      });
 
 
      
      
      trayIcon.setPopupMenu(menu);
      try{
          tray.add(trayIcon);
      }
      
      catch(Exception e){
      
      }
      }
      
      
      
      
      public static Image createIcon(String path, String desc){
      
      URL imageURL=TrayClass.class.getResource(path);
      return (new ImageIcon(imageURL,desc)).getImage();
      }
}    
