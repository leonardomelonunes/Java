/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.DAO;

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
public class ProdutoDAO {

    private Connection Conecta;
    private Statement ST;
    private ResultSet RS;

    public ProdutoDAO() {
        this.Conecta = SqlConecta.getConnection();
    }

    public ArrayList<ProdutoModel> SelecionaTudo() {
        try {
            ArrayList<ProdutoModel> Produtos = new ArrayList();
            ST = Conecta.createStatement();
            RS = ST.executeQuery("select * FROM produtos WHERE status = 1");

            while (RS.next()) {
                //System.out.println(RS.getString("nome"));
                ProdutoModel Produto = new ProdutoModel();
                Produto.setNome(RS.getString("nome"));
                Produto.setId_produto(RS.getInt("id_produto"));
                Produto.setUnidade(RS.getString("unidade"));
                Produto.setStatus(RS.getInt("status"));
                Produtos.add(Produto);
            }
            ST.close();
            return Produtos;
        } catch (SQLException Error) {
            throw new RuntimeException("ERROR");
        }
    }

    public ProdutoModel SelecionaPorID(String IdProduto) {
        try {

            ST = Conecta.createStatement();
            RS = ST.executeQuery("select * FROM produtos WHERE id_produto =" + IdProduto);

            RS.next();
            //System.out.println(RS.getString("nome"));
            ProdutoModel Produto = new ProdutoModel();
            Produto.setNome(RS.getString("nome"));
            Produto.setId_produto(RS.getInt("id_produto"));
            Produto.setUnidade(RS.getString("unidade"));
            Produto.setStatus(RS.getInt("status"));

            ST.close();
            return Produto;
        } catch (SQLException Error) {
            throw new RuntimeException("ERROR");
        }
    }

    public void Editar(ProdutoModel prod) {

        try {
            PreparedStatement ST = Conecta.prepareStatement("UPDATE produtos SET nome=?, unidade=?, status=? WHERE id_produto=?");
            ST.setString(1, prod.getNome());
            ST.setString(2, prod.getUnidade());
            ST.setInt(3, prod.getStatus());
            ST.setInt(4,prod.getId_produto());
            ST.execute();
            ST.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
