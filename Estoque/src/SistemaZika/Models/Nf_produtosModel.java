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
public class Nf_produtosModel {
    private int id_nf;
    private int id_produto;
    private int quantidade;
    private String valor;
    
    ProdutoModel produto;

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public int getId_nf() {
        return id_nf;
    }

    public void setId_nf(int id_nf) {
        this.id_nf = id_nf;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String decimal) {
        this.valor = decimal;
    }
    
    
}
