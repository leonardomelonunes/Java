/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.Models;

import java.sql.Date;




/**
 *
 * @author Leonardo Nunes
 */
public class UsuarioModel {
    private int id_usuario;
    private String nome;
    private String cpf;
    private String sexo;
    private String nascimento;
    private String tel_fixo;
    private String tel_celular;
    private String usarname;
    private String email;
    private String setor;
    private String grupo;
    private String senha;
    private int status;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getTel_fixo() {
        return tel_fixo;
    }

    public void setTel_fixo(String tel_fixo) {
        this.tel_fixo = tel_fixo;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }

    public String getUsarname() {
        return usarname;
    }

    public void setUsarname(String usarname) {
        this.usarname = usarname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
    
    
}
