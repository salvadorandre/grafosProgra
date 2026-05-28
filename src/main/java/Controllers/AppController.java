package Controllers;

import LibreriasConInteligenciaArtesanal.*;
import models.*;

public class AppController {

    private GrafoTurbo<Airport, Flight> graph;
    private Dijkstra<Airport, Flight> dijkstra;

    public AppController() {
        graph = new GrafoTurbo<>();
        dijkstra = new Dijkstra<>();
    }

    public void addAirport(String code, String city, String country) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("El código es obligatorio.");
        }

        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("La ciudad es obligatoria.");
        }

        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("El país es obligatorio.");
        }

        Airport airport = new Airport(
                code.trim().toUpperCase(),
                city.trim(),
                country.trim()
        );

        if (graph.containsNode(airport)) {
            throw new IllegalArgumentException("Ya existe un aeropuerto con código: " + airport.code);
        }

        graph.addNode(airport);
    }

    public void addFlight(
            Airport origin,
            Airport destination,
            String number,
            double price,
            double distance,
            double time
    ) {
        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Debe seleccionar origen y destino.");
        }

        if (origin.equals(destination)) {
            throw new IllegalArgumentException("El origen y destino no pueden ser iguales.");
        }

        if (number == null || number.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de vuelo es obligatorio.");
        }

        if (price < 0 || distance < 0 || time < 0) {
            throw new IllegalArgumentException("Precio, distancia y tiempo no pueden ser negativos.");
        }

        Flight flight = new Flight(
                number.trim().toUpperCase(),
                price,
                distance,
                time
        );

        graph.addConnection(origin, destination, flight);
    }

    public ListaIA<Airport> getAirports() {
        return graph.getNodes();
    }

    public Airport getAirportFromComboText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }

        String code = extractCode(text);

        ListaIA<Airport> airports = graph.getNodes();

        for (int i = 0; i < airports.size(); i++) {
            Airport airport = airports.getValue(i);

            if (airport.code.equalsIgnoreCase(code)) {
                return airport;
            }
        }

        return null;
    }

    public Result<Airport> findRoute(Airport origin, Airport destination, String criterion) {
        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Debe seleccionar origen y destino.");
        }

        if (criterion == null || criterion.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar un criterio.");
        }

        String cleanCriterion = criterion.trim().toLowerCase();

        switch (cleanCriterion) {
            case "precio":
                return dijkstra.shortestPath(graph, origin, destination, new PriceCriterion());

            case "tiempo":
                return dijkstra.shortestPath(graph, origin, destination, new TimeCriterion());

            case "distancia":
                return dijkstra.shortestPath(graph, origin, destination, new DistanceCriterion());

            default:
                throw new IllegalArgumentException("Criterio inválido.");
        }
    }

    public String getConnectionsLog() {
        return graph.toString();
    }

    public String formatRoute(Result<Airport> result, String criterion) {
        if (result == null || result.path == null || result.path.isEmpty()
                || result.totalWeight == Double.POSITIVE_INFINITY) {
            return "No existe una ruta entre los aeropuertos seleccionados.";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("Total: ")
                .append(result.totalWeight)
                .append(" ")
                .append(getUnit(criterion))
                .append("\n");

        sb.append("Ruta: ");

        for (int i = 0; i < result.path.size(); i++) {
            sb.append(result.path.getValue(i).code);

            if (i < result.path.size() - 1) {
                sb.append(" -> ");
            }
        }

        return sb.toString();
    }

    private String getUnit(String criterion) {
        if (criterion == null) {
            return "";
        }

        switch (criterion.trim().toLowerCase()) {
            case "precio":
                return "QTZ";

            case "tiempo":
                return "minutos";

            case "distancia":
                return "km";

            default:
                return "";
        }
    }

    private String extractCode(String text) {
        String cleanText = text.trim();
        int index = cleanText.indexOf(" ");

        if (index == -1) {
            return cleanText;
        }

        return cleanText.substring(0, index);
    }
}