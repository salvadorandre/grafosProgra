package LibreriasConInteligenciaArtesanal;

public class GrafoTurbo<T, E> {


    public static class Connection<T, E> {
        public T destination;
        public E edge;

        public Connection(T destination, E edge) {
            this.destination = destination;
            this.edge = edge;
        }
    }


    private SuperMapWhitIA<T, ListaIA<Connection<T, E>>> adjacency;

    public GrafoTurbo() {
        adjacency = new SuperMapWhitIA<>();
    }

    public void addNode(T node) {
        if (node == null) {
            throw new IllegalArgumentException("No puede ser nulo");
        }
        if (!adjacency.containsKey(node)) {
            adjacency.put(node, new ListaIA<>());
        }
    }


    public void addConnection(T origin, T destination, E edge) {
        if (edge == null) {
            throw new IllegalArgumentException("Arista no puede ser nula");
        }
        addNode(origin);
        addNode(destination);
        adjacency.getValue(origin).add(new Connection<>(destination, edge));
        adjacency.getValue(destination).add(new Connection<>(origin, edge));
    }



    public void addDirectedConnection(T origin, T destination, E edge) {
        if (edge == null) {
            throw new IllegalArgumentException("Arista no puede ser nula");
        }
        addNode(origin);
        addNode(destination);
        adjacency.getValue(origin).add(new Connection<>(destination, edge));
    }


    public ListaIA<Connection<T, E>> getConnections(T node) {
        if (!adjacency.containsKey(node)) {
            throw new IllegalArgumentException("Nodo no existe en el grafo: " + node);
        }
        return adjacency.getValue(node);
    }

    public ListaIA<T> getNodes() {
        return adjacency.keys();
    }

    public boolean containsNode(T node) {
        return adjacency.containsKey(node);
    }

    public void showConnections() {
        System.out.println("conexiones");
        ListaIA<T> nodes = getNodes();
        for (int i = 0; i < nodes.size(); i++) {
            T node = nodes.getValue(i);
            System.out.println("Desde " + node + ":");
            ListaIA<Connection<T, E>> connections = adjacency.getValue(node);
            for (int j = 0; j < connections.size(); j++) {
                Connection<T, E> conn = connections.getValue(j);
                System.out.println("  -> " + conn.destination + " via " + conn.edge);
            }
        }
    }

    public String getConnectionsAsString(T node) {
        if (!adjacency.containsKey(node)) {
            throw new IllegalArgumentException("nodo no existe en el grafo: " + node);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Conexiones desde ").append(node).append(":\n");

        ListaIA<Connection<T, E>> connections = adjacency.getValue(node);
        if (connections.isEmpty()) {
            sb.append("  (sin conexiones)\n");
            return sb.toString();
        }

        for (int i = 0; i < connections.size(); i++) {
            Connection<T, E> conn = connections.getValue(i);
            sb.append("  -> ").append(conn.destination)
                    .append(" via ").append(conn.edge).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("conexiones\n");

        ListaIA<T> nodes = getNodes();
        for (int i = 0; i < nodes.size(); i++) {
            T node = nodes.getValue(i);
            sb.append("Desde ").append(node).append(":\n");

            ListaIA<Connection<T, E>> connections = adjacency.getValue(node);
            for (int j = 0; j < connections.size(); j++) {
                Connection<T, E> conn = connections.getValue(j);
                sb.append("  -> ").append(conn.destination)
                        .append(" via ").append(conn.edge).append("\n");
            }
        }

        return sb.toString();
    }
}