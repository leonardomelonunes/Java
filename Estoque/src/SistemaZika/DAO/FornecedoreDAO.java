/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.DAO;

import SistemaZika.Models.FornecedorModel;
import SistemaZika.Models.ProdutoModel;
import exemplo.Pages.Fornecedores.Fornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Nunes
 */
public class FornecedoreDAO {
    private Connection Conecta;
    private Statement ST;
    private ResultSet RS;
    public FornecedoreDAO (){
        this.Conecta=SqlConecta.getConnection();
    }
    public ArrayList<FornecedorModel> SelecionaTudo (){
        try {
            ArrayList<FornecedorModel> Fornecedores = new ArrayList();
            ST=Conecta.createStatement();
            RS=ST.executeQuery("select * FROM fornecedores WHERE status = 1");
            
            while(RS.next()){
                //System.out.println(RS.getString("nome"));
                FornecedorModel Fornecedor = new FornecedorModel();
                Fornecedor.setNome(RS.getString("nome"));
                Fornecedor.setId_fornecedor(RS.getInt("id_fornecedor"));
                Fornecedor.setTelefone(RS.getString("telefone"));
                Fornecedor.setCnpj(RS.getString("cnpj"));
                Fornecedor.setStatus(RS.getInt("status"));
                Fornecedores.add (Fornecedor);
            }ST.close();
            return Fornecedores;
        }catch(SQLException Error){
            throw new RuntimeException("ERROR");
        }
    }
    public FornecedorModel SelecionaPorID (String IdFornecedor){
        try {
            
            ST=Conecta.createStatement();
            RS=ST.executeQuery("select * FROM fornecedores WHERE id_fornecedor =" + IdFornecedor);
            
            RS.next();
                //System.out.println(RS.getString("nome"));
                FornecedorModel Fornecedor = new FornecedorModel();
                Fornecedor.setNome(RS.getString("nome"));
                Fornecedor.setId_fornecedor(RS.getInt("id_fornecedor"));
                Fornecedor.setTelefone(RS.getString("telefone"));
                Fornecedor.setCnpj(RS.getString("cnpj"));
                Fornecedor.setStatus(RS.getInt("status"));
                
            ST.close();
            return Fornecedor;
        }catch(SQLException Error){
            throw new RuntimeException("ERROR");
        }
    }
    public void Editar(FornecedorModel prod) {

        try {
            PreparedStatement ST = Conecta.prepareStatement("UPDATE fornecedores SET nome=?, cnpj=?, telefone=?, status=? WHERE id_fornecedor=?");
            ST.setString(1, prod.getNome());
            ST.setString(2,prod.getCnpj());
            ST.setString(3, prod.getTelefone());
            ST.setInt(4, prod.getStatus());
            ST.setInt(5,prod.getId_fornecedor());
            ST.execute();
            ST.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<FornecedorModel> SelecionaTudoInativos (){
        try {
            ArrayList<FornecedorModel> Fornecedores = new ArrayList();
            ST=Conecta.createStatement();
            RS=ST.executeQuery("select * FROM fornecedores WHERE status = 0");
            
            while(RS.next()){
                //System.out.println(RS.getString("nome"));
                FornecedorModel Fornecedor = new FornecedorModel();
                Fornecedor.setNome(RS.getString("nome"));
                Fornecedor.setId_fornecedor(RS.getInt("id_fornecedor"));
                Fornecedor.setTelefone(RS.getString("telefone"));
                Fornecedor.setCnpj(RS.getString("cnpj"));
                Fornecedor.setStatus(RS.getInt("status"));
                Fornecedores.add (Fornecedor);
            }ST.close();
            return Fornecedores;
        }catch(SQLException Error){
            throw new RuntimeException("ERROR");
        }
    }
}    
