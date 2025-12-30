package br.com.Portifolio.Book_Teste;

import br.com.Portifolio.Book_Teste.Model.DadoLivro;
import br.com.Portifolio.Book_Teste.Model.Pessoa;
import br.com.Portifolio.Book_Teste.Model.ResponseGoogle;
import br.com.Portifolio.Book_Teste.Service.ConsumeApi;
import br.com.Portifolio.Book_Teste.Service.Conversor;
import br.com.Portifolio.Book_Teste.Service.LojaLivro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_B {

    private final String ENDERECO = "https://www.googleapis.com/books/v1/volumes?q=intitle:";
    private final String RESULTS = "maxResults=1";
    private ConsumeApi consumo = new ConsumeApi();
    private Conversor converte = new Conversor();
    private Pessoa pessoa = new Pessoa();


    Scanner leitura = new Scanner(System.in);

    List<DadoLivro> favoritos = new ArrayList<>();
    List<LojaLivro> carrinho = new ArrayList<>();

    public void menu() throws IOException,InterruptedException {
        var opcao ="";
        var opcao_favorito = "";
        var opcao_loja="";
        var opcao_compra="";

        System.out.println("Bem vindo a loja! Antes de iniciarmos, qual seu saldo atual: ");
        double Saldo_inicial = leitura.nextDouble();
        leitura.nextLine();
        pessoa.setSaldo(Saldo_inicial);
        System.out.println("Saldo de $ : " + pessoa.getSaldo() + ",configurado");

        while(!opcao.equalsIgnoreCase("sair")) {
            System.out.println("Se deseja pesquisar um livro digite [pesquisar], caso deseje sair digite [sair]");
            opcao = leitura.nextLine();
            if (opcao.equalsIgnoreCase("sair") || opcao.equalsIgnoreCase("Sair")) {
                System.out.println("saindo da biblioteca");
                break;
            }

            System.out.println("Digite o nome do livro que voce deseja: ");
            var nomeLivro = leitura.nextLine();
            var json = consumo.Consume(ENDERECO + nomeLivro.replaceAll(" ", "+")+ "&" + RESULTS);
            ResponseGoogle response = converte.ObterDados(json, ResponseGoogle.class);

            if (response.items() != null && !response.items().isEmpty()) {
                DadoLivro livro = response.items().get(0);
                System.out.println("Titulo : " + livro.info().titulo());
                System.out.println("Autores : " + livro.info().autores());
                System.out.println("Data de lancamento : " + livro.info().dataDeLancamento());
                System.out.println("Editora : " + livro.info().editora());
                System.out.println("Descricao do volume : " + livro.info().descricao());
                System.out.println("Numero de paginas : " + livro.info().numeroDePaginas());

                LojaLivro loja = new LojaLivro(livro);

                System.out.println("\n");
                System.out.println("Deseja adicionar esse livro a sua lista de desejos: [sim] ou [nao] ");
                opcao_favorito = leitura.nextLine();
                if(opcao_favorito.equalsIgnoreCase("sim")) {
                    favoritos.add(livro);
                } else if (opcao_favorito.equalsIgnoreCase("nao")) {
                    System.out.println(":)");
                }
                System.out.println("\n");
                System.out.println("Deseja adicionar esse livro a sua loja: [sim] ou [nao]");
                opcao_loja = leitura.nextLine();
                if(opcao_loja.equalsIgnoreCase("sim")){
                    carrinho.add(loja);
                }else if(opcao_loja.equalsIgnoreCase("nao")){
                    System.out.println("que pena");
                }
            }
        }
        System.out.println("Livros favoritos : ");
        favoritos.forEach(t -> System.out.println("Livro : "+ t.info().titulo() + " /Autor : " + t.info().autores()));
        System.out.println("Carrinho : ");
        carrinho.forEach(System.out::println);
        System.out.println("Deseja comprar os itens do carrinho :[sim] ou [nao] ");
        opcao_compra = leitura.nextLine();
        if(opcao_compra.equalsIgnoreCase("sim")){
            for(LojaLivro item : carrinho){
                pessoa.Pagar(item.getPreco());
                item.DiminuiEstoque();
            }
            System.out.println("Compra realizada. Saldo atual : " + pessoa.getSaldo());
        }
    }


}
