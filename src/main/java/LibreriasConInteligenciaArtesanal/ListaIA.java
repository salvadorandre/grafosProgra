package LibreriasConInteligenciaArtesanal;

public class ListaIA<T> {
    private Object[] data;
    private int length;

    public ListaIA() {
        data = new Object[10];
        length = 0;
    }

    public void add(T valor){
        if(this.length == data.length){
            enlarge();
        }
        data[length] = valor;
        length++;
    }
    private void enlarge(){
        int newCapacity = data.length * 2;
        Object[] aux = new Object[newCapacity];
        for(int i = 0; i < length; i++){
            aux[i] = data[i];
        }
        data = aux;
    }

    @SuppressWarnings("unchecked")
    public T getValue(int i){
        if(i < 0 || i >= length){
            throw new IndexOutOfBoundsException("Index out of bounds, indice is " + i + " i n v a l i d XD");
        }
        return (T) data[i];

    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public boolean contains(T valor){
        for(int i = 0; i < length; i++){
            if(valor.equals(getValue(i))){
                return true;
            }
        }
        return false;
    }

}
