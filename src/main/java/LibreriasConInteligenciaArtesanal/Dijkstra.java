package LibreriasConInteligenciaArtesanal;

import models.*;
import interfaces.WeightCriterion;

public class Dijkstra<T, E> {

    public Result<T> shortestPath(GrafoTurbo<T, E> graph, T start, T end, WeightCriterion<E> criterion) {
        SuperMapWhitIA<T, Double> distances = new SuperMapWhitIA<>();
        SuperMapWhitIA<T, T> previous = new SuperMapWhitIA<>();


        ListaIA<T> nodes = graph.getNodes();
        for (int i = 0; i < nodes.size(); i++) {
            distances.put(nodes.getValue(i), Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        QueuePriorityIA<Entry<T>> queue = new QueuePriorityIA<>();
        queue.insert(new Entry<>(start, 0.0));

        while (!queue.isEmpty()) {
            Entry<T> current = queue.popMin();
            T currentNode = current.node;
            double currentDist = current.accumulatedWeight;

            if (currentDist > distances.getValue(currentNode)) continue;
            if (currentNode.equals(end)) break;

            ListaIA<GrafoTurbo.Connection<T, E>> connections = graph.getConnections(currentNode);
            for (int i = 0; i < connections.size(); i++) {
                GrafoTurbo.Connection<T, E> conn = connections.getValue(i);
                double edgeWeight = criterion.getWeight(conn.edge);
                double newDist = currentDist + edgeWeight;

                if (newDist < distances.getValue(conn.destination)) {
                    distances.put(conn.destination, newDist);
                    previous.put(conn.destination, currentNode);
                    queue.insert(new Entry<>(conn.destination, newDist));
                }
            }
        }

        ListaIA<T> path = new ListaIA<>();
        if (distances.getValue(end) == Double.POSITIVE_INFINITY) {
            return new Result<>(path, Double.POSITIVE_INFINITY);
        }

        ListaIA<T> reversed = new ListaIA<>();
        T current = end;
        while (current != null) {
            reversed.add(current);
            current = previous.getValue(current);
        }
        for (int i = reversed.size() - 1; i >= 0; i--) {
            path.add(reversed.getValue(i));
        }

        return new Result<>(path, distances.getValue(end));
    }
}