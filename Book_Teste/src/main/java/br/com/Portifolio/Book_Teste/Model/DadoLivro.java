package br.com.Portifolio.Book_Teste.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadoLivro(@JsonAlias("volumeInfo") InfoLivros info) {
}
