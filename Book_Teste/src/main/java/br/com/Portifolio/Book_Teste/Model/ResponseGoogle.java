package br.com.Portifolio.Book_Teste.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseGoogle(@JsonAlias("items") List<DadoLivro> items) {
}
