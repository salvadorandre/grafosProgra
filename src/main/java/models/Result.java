package models;

import LibreriasConInteligenciaArtesanal.ListaIA;

public class Result<T> {
    public ListaIA<T> path;
    public double totalWeight;

    public Result(ListaIA<T> path, double totalWeight) {
        this.path = path;
        this.totalWeight = totalWeight;
    }
}