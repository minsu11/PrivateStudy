package parkminsu.privatestudy.generic;

public class Node<T> {
    Node<T> head;
    Node<T> tail;
    T data;

    public Node(Node<T> head, T data, Node<T> tail) {
        this.head = head;
        this.data = data;
        this.tail = tail;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +

                ", data=" + data +
                '}';
    }
}
