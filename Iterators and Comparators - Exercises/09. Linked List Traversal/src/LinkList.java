import java.util.Iterator;
import java.util.function.Consumer;

public class LinkList implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current=head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public Integer next() {
                int value=this.current.element;
                this.current=this.current.next;

                return value;
            }
        };
    }

    private class Node {
        private int element;
        private Node next;
        private Node prev;

        public Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public LinkList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int element) {

        if (this.head == null) {
            addLast(element);
        } else {
            Node newNode = new Node(element);
            newNode.next = this.head;
            this.head = newNode;
            this.size++;
        }

    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;

        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            if (this.head == null) {
                this.head.next = newNode;
            }
        }
        this.size++;
    }
    public void forEach(Consumer consumer) {
        Node currentNode = this.head;
        if (this.size != 1) {
            while (currentNode != null) {
                consumer.accept(currentNode.element);
                currentNode = currentNode.next;
            }
        } else {
            consumer.accept(currentNode.element);
        }

    }
    public void print() {
        Node currentNode = this.head;
        if (this.size != 1) {
            while (currentNode != null) {
                System.out.println(currentNode.element);
                currentNode = currentNode.next;
            }
        } else {
            System.out.println(currentNode.element);
        }

    }

    public int size() {
        return this.size;
    }
    public void remove(int element){


    }


    public Integer removeFirst() {
        if (this.head == null) {
            return null;
        } else {
            int element = this.head.element;
            this.head = this.head.next;
            this.size--;
            return element;
        }
    }

    public Integer removeLast() {
        if (this.tail == null) {
            return null;
        } else {
            Node currentNode = this.head;
            Node prev = currentNode;
            while (currentNode.next == null) {
                prev = currentNode;
                currentNode = currentNode.next;

            }
            int element=currentNode.element;

            this.tail=prev;
            this.tail.next=null;
            this.size--;
            if (this.size==0){
                this.head=null;
                this.tail=null;
            }
            return element;
        }
    }

    public int get(int count) {
        if (count < 0 || count > this.size) {
            throw new IndexOutOfBoundsException(count + "not Index of this LinkList");
        }
        Node currentNode = head;
        while (count-- > 0) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }
    public int[] toArray() {
        int [] element=new int[this.size];
        int index=0;
        Node currentNode = this.head;

        while (currentNode != null) {
            element[index++]=currentNode.element;
            currentNode = currentNode.next;
        }

        return element;

    }

}