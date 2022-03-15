/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika;

import exemplo.Pages.Fornecedores.AddFornecedor;
import exemplo.Pages.Fornecedores.Fornecedores;
import exemplo.Pages.NotasFiscais.ListaNotasFiscais;
import exemplo.Pages.Pedidos.Pedidos;
import exemplo.Pages.Produtos.Produtos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Leonardo Nunes
 */
public class Eventos {

    public static void setAcessibilidade(final JFrame frame) {
        JRootPane meurootpane = frame.getRootPane();

        //Quando a tecla Esc for pressionada fecha a tela
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[]{
                    ("Continuar"),
                    ("Minimizar"),
                    ("Sair")
                };
                int Answer = JOptionPane.showOptionDialog(null, ("Deseja realmente SAIR???"), "",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                if (Answer == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    
                } else if (Answer == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                } else {
                    frame.setVisible(false);
                    TrayClass tray = new TrayClass();
                }
            }

        });
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ENTER");
        meurootpane.getRootPane().getActionMap().put("ENTER", new AbstractAction("ENTER") {

            public void actionPerformed(ActionEvent e) {
                if (frame.getFocusOwner() instanceof JButton) {
                    JButton aux = (JButton) frame.getFocusOwner();
                    aux.doClick();
                } else if (frame.getFocusOwner() instanceof JPanel) {

                } else {
                    frame.getFocusOwner().transferFocus();
                }

            }
        });

    }

    public static void mudacorfoco(final JTextField field) {
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setBackground(new Color(255, 155, 13));
            }

            @Override
            public void focusLost(FocusEvent e) {
                field.setBackground(Color.WHITE);
            }
        });

    }

    public static void Acelerador(final JFrame frame) {

        JRootPane meurootpane = frame.getRootPane();
        //Quando a tecla CRTF for pressionada Chama Fornecedor
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK), "CTRF");
        meurootpane.getRootPane().getActionMap().put("CTRF", new AbstractAction("CTRF") {
            public void actionPerformed(ActionEvent e) {
                Aplicacao.Corpo.removeAll();
                Aplicacao.Corpo.revalidate();
                JPanel fornecedores = new Fornecedores();
                Aplicacao.Corpo.add(fornecedores, BorderLayout.CENTER);
                Fornecedores.jTextFieldPesquisar.requestFocus();
            }

        });

        //Quando a tecla CRTP for pressionada Chama Pedidos
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK), "CTRP");
        meurootpane.getRootPane().getActionMap().put("CTRP", new AbstractAction("CTRP") {
            public void actionPerformed(ActionEvent e) {
                Aplicacao.Corpo.removeAll();
        Aplicacao.Corpo.revalidate();
        JPanel produtos = new Produtos();
        Aplicacao.Corpo.add(produtos, BorderLayout.CENTER);
            }

        });
       // F1 AJUDA
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0), "AJUDA");
        meurootpane.getRootPane().getActionMap().put("AJUDA", new AbstractAction("AJUDA") {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null," MENU AJUDA: \n \n TECLAS DE ATALHO: \n \n CTRL + P = Tela Produtos. \n CTRL + F = Tela Fornecedores");
              
          }
      });
    }

}
