import java.util.Iterator;
/**A class that implements the ADT Dictionary by using a chain
 * of linked nodes. The dictionary is sorted and has distinct 
 * search keys. Search keys and associated values are not null.
 */

public class LinkedDictionary<K extends Comparable<? super K>, V> 
        implements DictionaryInterface<K, V> {
    
    private Node firstNode; //reference to first node of chain
    private int numberOfEntries;

    public LinkedDictionary() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public V add(K key, V value) {
        V result = null;
        if((key == null) || (value == null))
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        else {
            //search chain until you either find a node containing key
            //or locate where it should be
            Node currentNode = firstNode;
            Node nodeBefore = null;
            while((currentNode != null) && key.compareTo(currentNode.getKey()) > 0) {
                nodeBefore = currentNode;
                currentNode = currentNode.getNextNode();
            } //end while

            if ((currentNode != null) && (key.equals(currentNode.getKey()))) {
                result = currentNode.getValue();
                //get old value
                currentNode.setValue(value);
                //replace value
            }
            else {
                Node newNode = new Node(key, value);
                //create new node
                if(nodeBefore == null) {
                    //add at beginnnig
                    newNode.setNextNode(firstNode);
                    firstNode = newNode;
                }
                else {
                    newNode.setNextNode(currentNode);
                    nodeBefore.setNextNode(newNode);
                } //end if

                numberOfEntries++;
            } //end if
        }//end if
        return result;
    } //end add

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<V> getValueIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getSize() {
        return numberOfEntries;
    }

    public void clear() {
        firstNode = null;
    }

    private class Node {
        private K key;
        private V value;
        private Node next;
    
        private Node(K keyValue, V valuePortion) {
            key = keyValue;
            value = valuePortion;
            next = null;
        }
    
        private Node(K keyValue, V valuePortion, Node nextNode) {
            key = keyValue;
            value = valuePortion;
            next = nextNode;
        }
    
        public K getKey() {
            return key;
        }
    
        public V getValue() {
            return value;
        }

        private void setValue (V valuePortion) {
            value = valuePortion;
        }
        
        public Node getNextNode() {
            return next;
        }
    
        public void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}
