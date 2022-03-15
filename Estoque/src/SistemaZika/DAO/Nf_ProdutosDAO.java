/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.DAO;

import SistemaZika.Models.ModelNF;
import SistemaZika.Models.Nf_produtosModel;
import SistemaZika.Models.ProdutoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Nunes
 */
public class Nf_ProdutosDAO {

    private Connection Conecta;
    private Statement ST;
    private ResultSet RS;

    public Nf_ProdutosDAO() {
        this.Conecta = SqlConecta.getConnection();
    }

    public ArrayList<Nf_produtosModel> SelecionaTudo() {
        try {
            ArrayList<Nf_produtosModel> NFPs = new ArrayList();
            ST = Conecta.createStatement();
            RS = ST.executeQuery("select * FROM nf_produtos ");

            while (RS.next()) {
                //System.out.println(RS.getString("nome"));
                Nf_produtosModel NFP = new Nf_produtosModel();
                NFP.setId_nf(RS.getInt("id_nf"));
                NFP.setId_produto(RS.getInt("id_produto"));
                NFP.setQuantidade(RS.getInt("quantidade"));
                NFP.setValor(RS.getString("valor"));
                
                NFPs.add(NFP);
            }
            ST.close();
            return NFPs;
        } catch (SQLException Error) {
            throw new RuntimeException("ERROR");
        }
    }

    public ArrayList<Nf_produtosModel> SelecionaPorID(String IdNF) {
//        System.out.println(IdNF);
        try {

            ST = Conecta.createStatement();
            RS = ST.executeQuery("select * FROM nf_produtos LEFT JOIN produtos ON produtos.id_produto = nf_produtos.id_produto WHERE nf_produtos.id_nf =" + IdNF);
            
            ArrayList<Nf_produtosModel> produtos = new ArrayList();
            while (RS.next()){ 
            
            //System.out.println(RS.getString("nome"));
           Nf_produtosModel NF2 = new Nf_produtosModel();
           ProdutoModel Item = new ProdutoModel();
           Item.setId_produto(RS.getInt("produtos.id_produto"));
           Item.setNome(RS.getString("nome"));
           Item.setUnidade(RS.getString("unidade"));
           NF2.setProduto(Item);
           NF2.setValor(RS.getString("valor"));
           NF2.setQuantidade(RS.getInt("quantidade"));
           
           produtos.add(NF2);
            }
            

            ST.close();
            return produtos;
        } catch (SQLException Error) {
            throw new RuntimeException("ERROR");
        }
    }

    public void Editar (Nf_produtosModel NF) {

        try {
            PreparedStatement ST = Conecta.prepareStatement("UPDATE nf_produtos SET quantidade=?, valor=?, data=? WHERE id_Produto=?");
            ST.setInt(1, NF.getQuantidade());
            ST.setString(2, NF.getValor());
            
            
            ST.execute();
            ST.close();

        } catch (SQLException ex) {
            Logger.getLogger(Nf_ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        
        
    }
    public void deletarP(int Id) {
        String sql = "DELETE FROM nf_produtos WHERE Id=?";
        try {
            ST = Conecta.prepareStatement(sql);
            //ST.setInt(1, Id);
            ST.executeQuery(sql);
            ST.close();   
        } catch(SQLException error) {
            throw new RuntimeException("NotaFiscalDAO.deletar: " + error);
        }
    }
}
