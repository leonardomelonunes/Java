/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaZika.Models;

/**
 *
 * @author Leonardo Nunes
 */
public class ModelNF {
    private int id_nf;
    private int numero;
    private String serie;
    private Double valor;
    private String data;
    private int id_fornecedor;
    

    public int getId_nf() {
        return id_nf;
    }

    public void setId_nf(int id_nf) {
        this.id_nf = id_nf;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
    
    
 
    
}
