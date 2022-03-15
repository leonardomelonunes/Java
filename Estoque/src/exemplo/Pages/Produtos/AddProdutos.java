/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.Pages.Produtos;

import SistemaZika.DAO.ProdutoDAO;
import SistemaZika.DAO.SqlConecta;
import SistemaZika.Eventos;
import SistemaZika.LimitaQtdaCaracteres;
import SistemaZika.Models.ProdutoModel;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Nunes
 */
public class AddProdutos extends javax.swing.JFrame {
    SqlConecta conecta = new SqlConecta();
    private ProdutoModel produto;
    private ProdutoDAO pdao;

    /**
     * Creates new form AddProdutos
     */
    public AddProdutos() {
        initPage();
        jButtonEditar.setVisible(false);
        
        
        
    }
    public AddProdutos(String id_produto){
        initPage();
        jButton1.setVisible(false);
         pdao = new ProdutoDAO();
         produto = pdao.SelecionaPorID(id_produto);
        jTextFieldNome.setText(produto.getNome());
        jTextFieldUnidade.setText(produto.getUnidade());
        jComboBoxStatusP.setSelectedItem(produto.getStatus());
    }
    public void initPage(){
        initComponents();
        Eventos.setAcessibilidade(this);
        jTextFieldNome.requestFocus();
        Eventos.mudacorfoco(jTextFieldNome);
        Eventos.mudacorfoco(jTextFieldUnidade);
        jTextFieldNome.setDocument (new LimitaQtdaCaracteres(254));
        jTextFieldUnidade.setDocument(new LimitaQtdaCaracteres(45));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldUnidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxStatusP = new javax.swing.JComboBox<>();
        jButtonEditar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 234, -1));
        getContentPane().add(jTextFieldUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 146, 234, -1));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("exemplo/Pages/Produtos/Bundle"); // NOI18N
        jLabel2.setText(bundle.getString("AddProdutos.jLabel2.text")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, 38, -1));

        jLabel3.setText(bundle.getString("AddProdutos.jLabel3.text")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, -1, -1));

        jLabel4.setText(bundle.getString("AddProdutos.jLabel4.text")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, -1, -1));

        jLabel1.setText(bundle.getString("AddProdutos.jLabel1.text")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton1.setText(bundle.getString("AddProdutos.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jComboBoxStatusP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inativo", "Ativo", " " }));
        getContentPane().add(jComboBoxStatusP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 204, 94, -1));

        jButtonEditar.setText(bundle.getString("AddProdutos.jButtonEditar.text")); // NOI18N
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 237, 77, -1));

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText(bundle.getString("AddProdutos.jLabel5.text")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText(bundle.getString("AddProdutos.jLabel6.text")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
//        jTextFieldNome.setBackground(Color.white);
//        String Nome = jTextFieldNome.getText().trim();
//        boolean valido = true;
//        if (Nome.equals("")) {
//            valido = false;
//            jTextFieldNome.setBackground(Color.red);
//        }
//        
//        
//        
//        if (valido) {
            //System.out.println("Salvar AquiBD");
            if (jTextFieldNome.getText().equals("")){
                jTextFieldNome.requestFocus();
                JOptionPane.showMessageDialog(null, "O campo Nome é obrigatório","Aviso",JOptionPane.WARNING_MESSAGE);
                return;
            }  
            if (jTextFieldUnidade.getText().equals("")){
                jTextFieldUnidade.requestFocus();
                JOptionPane.showMessageDialog(null, "O campo Unidade é obrigatório","Aviso",JOptionPane.WARNING_MESSAGE);
                return;
            }   
            
            try {
           PreparedStatement pst = conecta.getConnection().prepareStatement("insert into Produtos(nome,unidade,status)values(?,?,?)");
           pst.setString(1, jTextFieldNome.getText());
           pst.setString(2, jTextFieldUnidade.getText());
           pst.setInt(3, jComboBoxStatusP.getSelectedIndex());
          


           pst.executeUpdate();
           JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso!");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(rootPane, "   Erro na inserção! \n ERRO:"+ex);;
       }
            this.setVisible(false);
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        produto.setNome(jTextFieldNome.getText());
        produto.setUnidade(jTextFieldUnidade.getText());
        produto.setStatus(jComboBoxStatusP.getSelectedIndex());
        
        pdao.Editar(produto);
        JOptionPane.showMessageDialog(null, "Editado com Sucesso");
        
        
        this.setVisible(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JComboBox<String> jComboBoxStatusP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldUnidade;
    // End of variables declaration//GEN-END:variables
}