

/**
 * A class that implements a queue of objectrs by using a
 * chain of linked noked
 */

public final class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode; //references node at front of queue
    private Node lastNode; //references node at back of queue

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    } //end default constructor

    //implementations of queue operations

    //adds a new node to the back of the queue
    //@param newEntry the entry to be added
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if(isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    }

    //retrieves the entry at the front of the queue
    //@return the value at the front of the queue
    public T getFront() {
        if(isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    }

    //removes the first element in the queue
    //@return the first element being removed in the queue
    public T dequeue() {
        T front = getFront(); //might throw EmptyQueueException
        //assertion: firstNode != null
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if (firstNode == null) {
            lastNode = null;
        }
        return front;
    } //end dequeue

    //checks if queue is empty
    //@returns true if the queue is empty
    public boolean isEmpty() {
        return (firstNode ==null) && (lastNode==null);
    }

    //clears the queue
    public void clear() {
        firstNode = null;
        lastNode = null;
    }


    //class node
    private class Node {
        private T data; //entry in queue
        private Node next; //link to next node

        public Node(T d, Node n) {
            data = d;
            next = n;
        }

        public T getData() {
            return data;
        }
        
        public void setData(T d) {
            data = d;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node n) {
            next = n;
        }
    }//end Node
}//end LinkedQueue
