package LibreriasConInteligenciaArtesanal;

import models.Node;

import java.util.function.Supplier;

public class QueueIA<Z> {

    private Node<Z> front;
    private Node<Z> back;
    private int length;

    public QueueIA() {
        this.front = null;
        this.back = null;
        this.length = 0;
    }

    public void addToQueue(Z value){
        Node<Z> newNode = new Node<>(value);
        if(this.front == null){
            this.front = newNode;
            this.back = newNode;
        }else {
            back.next = newNode;
            back = newNode;
        }
        this.length++;
    }

    public Z removeFromQueue(){
        if(this.front == null){
            throw  new IllegalStateException("queue is empty");
        }
        Z value = front.value;
        front = front.next;

        if(front == null){
            back = null;
        }
        this.length--;
        return value;
    }

    public boolean isEmpty(){
        return this.length == 0;
    }
    private final Supplier<Integer> getLengthFunction = () -> this.length;

    public int getLength(){
        return getLengthFunction.get();
    }
}
