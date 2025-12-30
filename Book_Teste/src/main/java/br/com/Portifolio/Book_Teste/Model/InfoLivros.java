package br.com.Portifolio.Book_Teste.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record InfoLivros(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<String> autores,
                         @JsonAlias("publishedDate") String dataDeLancamento,
                         @JsonAlias("publisher")String editora,
                         @JsonAlias("description")String descricao,
                         @JsonAlias("pageCount")Integer numeroDePaginas) {
}
