package br.com.Portifolio.Book_Teste.Model;

public class Pessoa {

    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void Pagar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
        }else{
            throw new RuntimeException("Saldo insuficiente");
        }
    }
}
