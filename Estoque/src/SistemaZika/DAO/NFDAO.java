/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.DAO;

import SistemaZika.Models.FornecedorModel;
import SistemaZika.Models.ModelNF;

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
public class NFDAO {

    private Connection Conecta;
    private Statement ST;
    private ResultSet RS;

    public NFDAO() {
        this.Conecta = SqlConecta.getConnection();
    }

    public ArrayList<ModelNF> SelecionaTudo() {
        try {
            ArrayList<ModelNF> NFs = new ArrayList();
            ST = Conecta.createStatement();
            RS = ST.executeQuery("select * FROM nf ");

            while (RS.next()) {
                //System.out.println(RS.getString("nome"));
                ModelNF NF = new ModelNF();
                NF.setId_nf(RS.getInt("id_nf"));
                NF.setNumero(RS.getInt("numero"));
                NF.setSerie(RS.getString("serie"));
                NF.setValor(RS.getDouble("valor"));
                NF.setData(RS.getString("data"));
                NF.setId_fornecedor(RS.getInt("id_fornecedor"));
                NFs.add(NF);
            }
            ST.close();
            return NFs;
        } catch (SQLException Error) {
            throw new RuntimeException("ERROR");
        }
    }

    public ModelNF SelecionaPorID(String IdNF) {
        try {

            ST = Conecta.createStatement();
            RS = ST.executeQuery("select * FROM nf WHERE id_nf =" + IdNF);

            RS.next();
            //System.out.println(RS.getString("nome"));
            ModelNF NF = new ModelNF();
            NF.setId_nf(RS.getInt("id_nf"));
            NF.setNumero(RS.getInt("numero"));
            NF.setSerie(RS.getString("serie"));
            NF.setValor(RS.getDouble("valor"));
            NF.setData(RS.getString("data"));
            NF.setId_fornecedor(RS.getInt("id_fornecedor"));

            ST.close();
            return NF;
        } catch (SQLException Error) {
            throw new RuntimeException("ERROR");
        }
    }

    public void Editar(ModelNF NF) {

        try {
            PreparedStatement ST = Conecta.prepareStatement("UPDATE nf SET id_fornecedor=?, numero=?, serie=?, valor=? WHERE id_nf=?");
            ST.setInt(1, NF.getId_fornecedor());
            ST.setInt(2, NF.getNumero());
            ST.setString(3, NF.getSerie());
            ST.setDouble(4, NF.getValor());
            ST.setInt(5,NF.getId_nf());
            

            ST.execute();
            ST.close();

        } catch (SQLException ex) {
            Logger.getLogger(NFDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public ModelNF selecionaId(String Id) {

        ModelNF nf = new ModelNF();

        try {

            ST = Conecta.createStatement();
            RS = ST.executeQuery("SELECT * FROM `nf` LEFT JOIN fornecedores ON fornecedores.id_fornecedor = nf.id_fornecedor WHERE "
                    + "nf.id_nf = " + Id);
//           ps = Conecta.prepareStatement
//           rs = ps.executeQuery();

            while (RS.next()) {
                FornecedorModel forn = new FornecedorModel();

                forn.setId_fornecedor(RS.getInt("id_fornecedor"));
                forn.setCnpj(RS.getString("fornecedores.cnpj"));
                forn.setNome(RS.getString("fornecedores.nome"));

                nf.setId_fornecedor(RS.getInt("nf.id_fornecedor"));
                nf.setNumero(RS.getInt("numero"));
                nf.setSerie(RS.getString("serie"));
                //nf.set(rs.getString("status"));
                nf.setValor(RS.getDouble("valor"));
                nf.setData(RS.getString("data"));
                nf.setId_fornecedor(RS.getInt("nf.id_fornecedor"));
            }
            ST.close();
            return nf;
        } catch (SQLException ex) {
            //System.out.println(ex);
            //Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("ERROR");
//       } finally {
//           //Conecta.closeConnection(con, ps, rs);
//           return nf;
        }

    }

}
