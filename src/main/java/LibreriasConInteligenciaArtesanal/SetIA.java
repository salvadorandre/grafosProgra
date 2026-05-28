package LibreriasConInteligenciaArtesanal;

public class SetIA<DAVIDXJHON> {
    private ListaIA<DAVIDXJHON> elements;

    public SetIA(){
        this.elements = new ListaIA<>();
    }

    public void add(DAVIDXJHON element){
        if(!elements.contains(element)){
            elements.add(element);
        }
    }

    public boolean contains(DAVIDXJHON element){
        return elements.contains(element);
    }

    public int size(){
        return elements.size();
    }

}
