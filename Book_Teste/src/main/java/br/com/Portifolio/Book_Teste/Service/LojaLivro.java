package br.com.Portifolio.Book_Teste.Service;

import br.com.Portifolio.Book_Teste.Model.DadoLivro;

public class LojaLivro {
    private String titulo;
    private Double preco;
    private Integer estoque;

    public LojaLivro(DadoLivro dadoLivro){
        this.titulo = dadoLivro.info().titulo();
        this.preco = Math.random() * 50 + 10;
        this.estoque = 5;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque){
        this.estoque = estoque;
    }

    public void DiminuiEstoque(){
        if(this.estoque > 0){
            estoque--;
        }else{
            System.out.println("Erro");
        }
    }

    @Override
    public String toString() {
        return String.format("Livro : %s | Preco : %.2f |Estoque : %d",titulo,preco, estoque);
    }
}
