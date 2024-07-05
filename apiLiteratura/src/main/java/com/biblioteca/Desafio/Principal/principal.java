package com.biblioteca.Desafio.Principal;

import com.biblioteca.Desafio.Service.ConsumoAPI;
import com.biblioteca.Desafio.Service.ConvierteDatos;
import com.biblioteca.Desafio.model.Datos;
import com.biblioteca.Desafio.model.Datoslibros;

import java.util.*;
import java.util.stream.Collectors;

public class principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI apiConsumer = new ConsumoAPI();
    private final String BASE_URL = "https://gutendex.com/books/";
    private final String SEARCH_API = "?search=";
    private ConvierteDatos dataConverter = new ConvierteDatos();
    
    public void mostrarMenu() {
        // Obtener datos de la API
        var jsonResponse = apiConsumer.obtenerDatos(BASE_URL);
        System.out.println(jsonResponse);
        
        // Convertir JSON a objeto Datos
        var datos = dataConverter.obtenerDatos(jsonResponse, Datos.class);
        System.out.println("Datos");

        // Obtener lista de libros
        List<Datoslibros> libros = datos.resultados();

        // Mostrar los primeros 5 libros obtenidos de la API
        List<Datoslibros> primerosCincoLibros = libros.stream()
                .limit(5)
                .collect(Collectors.toList());
        primerosCincoLibros.forEach(System.out::println);

        // Mostrar los 10 libros más descargados
        System.out.println("Top 10 Libros Más Descargados");
        libros.stream()
                .sorted(Comparator.comparing(Datoslibros::numeroDescargas).reversed())
                .map(libro -> libro.titulo().toUpperCase())
                .limit(10)
                .forEach(System.out::println);

        // Buscar libro por nombre
        System.out.println("¿Qué libro deseas buscar?");
        var nombreLibro = scanner.nextLine();
        jsonResponse = apiConsumer.obtenerDatos(BASE_URL + SEARCH_API + nombreLibro.replace(" ", "%20"));
        var datosLibros = dataConverter.obtenerDatos(jsonResponse, Datos.class);
        Optional<Datoslibros> libroBuscado = datosLibros.resultados().stream()
                .filter(libro -> libro.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro encontrado:"
                    + "\nDatos del libro: " + libroBuscado.get());
        } else {
            System.out.println("Libro no encontrado");
        }

        // Estadísticas de descargas de libros
        DoubleSummaryStatistics estadisticas = datos.resultados().stream()
                .collect(Collectors.summarizingDouble(Datoslibros::numeroDescargas));
        System.out.println("Estadísticas de Descargas:"
                + "\nMedia: " + estadisticas.getAverage()
                + "\nNúmero máximo de descargas: " + estadisticas.getMax()
                + "\nNúmero mínimo de descargas: " + estadisticas.getMin()
                + "\nCantidad total de libros: " + estadisticas.getCount());
    }
}
