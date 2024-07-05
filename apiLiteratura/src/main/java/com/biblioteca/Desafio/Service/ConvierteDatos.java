package com.biblioteca.Desafio.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public <T> T convertirDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir JSON a objeto de tipo " + clase.getSimpleName(), e);
        }
    }
}
