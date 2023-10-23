package parkminsu.privatestudy.generic;

public class LinkedList<T> {
    Node<T> first;
    Node<T> last;
    int size;

    public boolean add(T data) {
        addLast(data);
        return true;
    }

    private void addFirst(T data) {
        Node firstNode = first;
        Node newNode = new Node(null, data, firstNode);
        first = newNode;
        if (last == null) {
            last = newNode;
        } else {
            firstNode.head = newNode;
        }
    }

    private void addLast(T data) {
        Node lastNode = last;
        Node nextNode = new Node(lastNode, data, null);
        last = nextNode;
        if (lastNode == null) {
            first = nextNode;
        } else {
            lastNode.tail = nextNode;
        }
        size++;
    }

    public Object get(int index) {
        if (this.first == null) {
            throw new IllegalArgumentException("노드가 없습니다.");
        }
        Node newNode = this.first;
        for (int i = 0; i < index; i++) {
            newNode = newNode.tail;
        }
        return newNode.data;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}
