
package MainPackage;

import LibreriasConInteligenciaArtesanal.Dijkstra;
import LibreriasConInteligenciaArtesanal.GrafoTurbo;
import LibreriasConInteligenciaArtesanal.QueueIA;
import models.*;

/**
 *
 * @author allan
 * @author admin
 */
public class ProyectoPrograGrafos {

    public static void main(String[] args) {
        GrafoTurbo<Airport, Flight> network = new GrafoTurbo<>();

        Airport gua = new Airport("GUA", "Guatemala City", "Guatemala");
        Airport mex = new Airport("MEX", "Mexico City", "Mexico");
        Airport mia = new Airport("MIA", "Miami", "USA");
        Airport lax = new Airport("LAX", "Los Angeles", "USA");
        Airport jfk = new Airport("JFK", "New York", "USA");


        network.addConnection(gua, mex, new Flight("AV101", 250, 1100, 150));
        network.addConnection(gua, mia, new Flight("AA202", 380, 1600, 180));
        network.addConnection(mex, lax, new Flight("AM303", 320, 2500, 240));
        network.addConnection(mex, jfk, new Flight("DL404", 450, 3360, 300));
        network.addConnection(mia, jfk, new Flight("AA505", 200, 1750, 180));
        network.addConnection(mia, lax, new Flight("AA606", 350, 3760, 350));
        network.addConnection(lax, jfk, new Flight("UA707", 280, 3940, 360));

        System.out.println(network);

        Airport gua2 = new Airport("GUA", "Guatemala City", "Guatemala");
        Airport gua3 = new Airport("MEX", "Mexico City", "Mexico");
        Airport mia4 = new Airport("MIA", "Miami", "USA");

        network.addNode(gua2);
        network.addNode(gua3);
        network.addNode(mia4);


        network.addConnection(gua2, gua3, new Flight("AV101", 250, 1100, 150));
        network.addConnection(gua2, mia4, new Flight("AA202", 380, 1600, 180));
        network.addConnection(gua3, mia4, new Flight("AM303", 200, 2000, 200));


        System.out.println(network.getConnectionsAsString(gua));

        Dijkstra<Airport, Flight> dijkstra = new Dijkstra<>();

        // Vuelo mas barato
        System.out.println();
        System.out.println("dinero GUA -> JFK");
       Result<Airport> cheap = dijkstra.shortestPath(
                network, gua, jfk, new PriceCriterion()
        );
        printResult(cheap, "QTZ");

        // Vuelo rapidin
        System.out.println();
        System.out.println("rapido GUA -> JFK");
        Result<Airport> fast = dijkstra.shortestPath(
                network, gua, jfk, new TimeCriterion()
        );
        printResult(fast, "minutes");

        // Vuelo corto
        System.out.println();
        System.out.println(" distancia GUA -> JFK ");
       Result<Airport> shortDist = dijkstra.shortestPath(
                network, gua, jfk, new DistanceCriterion()
        );
        printResult(shortDist, "km");
    }

    static void printResult(Result<Airport> result, String unit) {
        System.out.println("Total: " + result.totalWeight + " " + unit);
        for (int i = 0; i < result.path.size(); i++) {
            System.out.print(result.path.getValue(i).code);
            if (i < result.path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
    }
}
