import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedListWithIterator<T> {
    private Node firstNode;
    private int numberOfEntries;

    public LinkedListWithIterator() {
        initializeDataFields();
    } //end default constructor

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    public Iterator<T> iterator() {
        return new IteratorForLinkedList();
    }//end Iterator


    private class IteratorForLinkedList implements Iterator<T> {
        private Node nextNode;

        private IteratorForLinkedList() {
            nextNode = firstNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            T result;
            if(hasNext()) {
                result = nextNode.getData();
                nextNode = nextNode.getNextNode(); //advance iterator
            } else
                throw new NoSuchElementException("Illegal call to next();");
            return result;
        }

        //implementations
    }//end linkedlist


    private class Node {
        private T data;
        private Node next;
    
        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }
    
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    
        public T getData() {
            return data;
        }
        
        public Node getNextNode() {
            return next;
        }
    
    }

}


