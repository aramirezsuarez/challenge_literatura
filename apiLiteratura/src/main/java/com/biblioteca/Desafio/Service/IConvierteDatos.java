package com.biblioteca.Desafio.Service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
