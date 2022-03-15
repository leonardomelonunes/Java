/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika;



import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo Nunes
 */


public class FieldListner implements FocusListener {
    public void focusGained(FocusEvent e) {
        Object o = e.getSource();
        if (o instanceof JTextField) {
            JTextField f = (JTextField) o;
            f.setBackground(new Color(173, 177, 226));
        }
    }

    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if (o instanceof JTextField) {
            JTextField f = (JTextField) o;
            f.setBackground(new Color(219, 230, 156));
        }

    }

    
}


