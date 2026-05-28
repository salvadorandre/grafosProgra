package LibreriasConInteligenciaArtesanal;

import models.Weighable;

public class QueuePriorityIA<T extends Weighable> {

    private ListaIA<T> elementos;

    public QueuePriorityIA() {
        elementos = new ListaIA<>();
    }

    public void insert(T value) {
        elementos.add( value);
    }


    public T popMin() {
        if (elementos.isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }


        int indiceMin = 0;
        for (int i = 1; i < elementos.size(); i++) {
            if (elementos.getValue(i).getWeight() < elementos.getValue(indiceMin).getWeight()) {
                indiceMin = i;
            }
        }

        T min = elementos.getValue(indiceMin);


        ListaIA<T> nueva = new ListaIA<>();
        for (int i = 0; i < elementos.size(); i++) {
            if (i != indiceMin) {
                nueva.add(elementos.getValue(i));
            }
        }
        elementos = nueva;

        return min;
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

}
