/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.DAO;

import SistemaZika.Models.UsuarioModel;
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
public class UsuarioDAO {

    private Connection Conecta;
    private Statement ST;
    private ResultSet RS;
    public UsuarioDAO (){
        this.Conecta=SqlConecta.getConnection();
    }
    public ArrayList<UsuarioModel> SelecionaTudo (){
        try {
            ArrayList<UsuarioModel> Usuarios = new ArrayList();
            ST=Conecta.createStatement();
            RS=ST.executeQuery("select * FROM usuarios");
            
            while(RS.next()){
                                
                UsuarioModel Usuario = new UsuarioModel();
                
                Usuario.setId_usuario(RS.getInt("id_usuario"));
                Usuario.setNome(RS.getString("nome"));
                Usuario.setCpf(RS.getString("cpf"));
                Usuario.setSexo(RS.getString("sexo"));
                Usuario.setNascimento(RS.getString("nascimento"));
                Usuario.setTel_fixo(RS.getString("tel_fixo"));
                Usuario.setTel_celular(RS.getString("tel_celular"));
                Usuario.setEmail(RS.getString("email"));
                Usuario.setSetor(RS.getString("setor"));
                Usuario.setGrupo(RS.getString("grupo"));
                Usuario.setUsarname(RS.getString("usarname"));
                Usuario.setSenha(RS.getString("senha"));
                Usuario.setStatus(RS.getInt("status"));
                Usuarios.add (Usuario);
            }ST.close();
            return Usuarios;
        }catch(SQLException Error){
            throw new RuntimeException(Error);
        }
    }
    public UsuarioModel SelecionaPorID (String IdUsuario){
        try {
            
            ST=Conecta.createStatement();
            RS=ST.executeQuery("select * FROM usuarios WHERE id_usuario =" + IdUsuario);
            
            RS.next();
                //System.out.println(RS.getString("nome"));
                UsuarioModel Usuario = new UsuarioModel();
                Usuario.setNome(RS.getString("nome"));
                Usuario.setId_usuario(RS.getInt("id_usuario"));
                Usuario.setCpf(RS.getString("cpf"));
                Usuario.setSexo(RS.getString("sexo"));
                Usuario.setNascimento(RS.getString("nascimento"));
                Usuario.setTel_fixo(RS.getString("tel_fixo"));
                Usuario.setTel_celular(RS.getString("tel_celular"));
                Usuario.setUsarname(RS.getString("usarname"));
                Usuario.setEmail(RS.getString("email"));
                Usuario.setSetor(RS.getString("setor"));
                Usuario.setGrupo(RS.getString("grupo"));
                Usuario.setSenha(RS.getString("senha"));
                Usuario.setStatus(RS.getInt("status"));
                
            ST.close();
            return Usuario;
        }catch(SQLException Error){
            throw new RuntimeException("ERROR");
        }
    }
    public void Editar(UsuarioModel prod) {

        try {
            PreparedStatement ST = Conecta.prepareStatement("UPDATE usuarios SET nome=?, cpf=?, sexo=?, nascimento=?, tel_fixo=?, tel_celular=?, email=?, setor=?, grupo=?, usarname=?, senha=?, status=? WHERE id_usuario=?");
            ST.setString(1, prod.getNome());
            ST.setString(2,prod.getCpf());
            ST.setString(3,prod.getSexo());
            ST.setString(4,prod.getNascimento());
            ST.setString(5,prod.getTel_fixo());
            ST.setString(6,prod.getTel_celular());
            ST.setString(7,prod.getEmail());
            ST.setString(8,prod.getSetor());
            ST.setString(9,prod.getGrupo());
            ST.setString(10,prod.getUsarname());
            ST.setString(11,prod.getSenha());
            ST.setInt(12, prod.getStatus());
            ST.setInt(13,prod.getId_usuario());
            ST.execute();
            ST.close();
           
            
             }catch(SQLException Error){
                 
                 System.err.println("Erro update: " + Error.getMessage() + Error.getSQLState()  );
                 
            //throw new RuntimeException(Error);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}

    

