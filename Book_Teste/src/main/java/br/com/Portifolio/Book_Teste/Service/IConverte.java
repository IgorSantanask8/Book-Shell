package br.com.Portifolio.Book_Teste.Service;

public interface IConverte {
    <T> T ObterDados(String json, Class<T> tclass);
}
