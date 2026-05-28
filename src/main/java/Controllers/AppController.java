package Controllers;

import LibreriasConInteligenciaArtesanal.*;
import models.*;

public class AppController {
    private GrafoTurbo<Airport, Flight> graph = new GrafoTurbo<>();
    private Dijkstra<Airport, Flight> dijkstra = new Dijkstra<>();

    // Registrar aeropuerto
    public void addAirport(String code, String name, String country) {
        graph.addNode(new Airport(code, name, country));
    }

    // Registrar vuelo (bidireccional)
    public void addFlight(Airport origin, Airport dest,
                          String num, double price, double dist, double time) {
        graph.addConnection(origin, dest, new Flight(num, price, dist, time));
    }

    // Obtener todos los aeropuertos (para llenar combos en la UI)
    public ListaIA<Airport> getAirports() {
        return graph.getNodes();
    }

    // Buscar ruta
    public Result<Airport> findRoute(Airport from, Airport to, String criterion) {
        return switch (criterion) {
            case "precio"    -> dijkstra.shortestPath(graph, from, to, new PriceCriterion());
            case "tiempo"    -> dijkstra.shortestPath(graph, from, to, new TimeCriterion());
            default          -> dijkstra.shortestPath(graph, from, to, new DistanceCriterion());
        };
    }

    // Log de conexiones
    public String getConnectionsLog() {
        return graph.toString();
    }
}