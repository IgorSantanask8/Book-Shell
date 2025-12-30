package br.com.Portifolio.Book_Teste;

import br.com.Portifolio.Book_Teste.Model.DadoLivro;
import br.com.Portifolio.Book_Teste.Model.ResponseGoogle;
import br.com.Portifolio.Book_Teste.Service.ConsumeApi;
import br.com.Portifolio.Book_Teste.Service.Conversor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookTesteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookTesteApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Main_B main = new Main_B();
        main.menu();
    }
}
