package br.com.Portifolio.Book_Teste.Service;

import tools.jackson.databind.ObjectMapper;

public class Conversor implements IConverte{

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T ObterDados(String json, Class<T> tclass) {
        return mapper.readValue(json, tclass);
    }
}
