import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vertex<T> implements VertexInterface<T> {
    private T label;
    private LinkedListWithIterator<Edge> edgeList; //edges to neighbors
    private boolean visited; //true if visited

    public Vertex(T vertexLabel) {
        label = vertexLabel;
        edgeList = new LinkedListWithIterator<>();
        visited = false;
    }
    

    public T getLabel() {
        return label;
    }

    public void visit() {
        visited = true;
    }

    public void unvisit() {
        visited = false;
        
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean hasNeighbor() {
        return !edgeList.isEmpty();
    }

    public VertexInterface<T> getUnvisitedNeighbor() {
        VertexInterface<T> result = null;
        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
        while (neighbors.hasNext() && (result == null)) {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if(!nextNeighbor.isVisited()) {
                result = nextNeighbor;
            }//end if
        }//end while
        return result;
    }//ebd getUnvisitedNeighbor

    public boolean equals(Object other) {
        boolean result;
        if((other == null) || (getClass() != other.getClass()))
            result = false;
        else {
            //the cast is safe within this else clause
            @SuppressWarnings("unchecked")
            Vertex<T> otherVertex = (Vertex<T>) other;
            result = label.equals(otherVertex.label);
        }//end if
        return result;
    }//end equals

    protected class Edge {
        private VertexInterface<T> vertex; //vertex at end of edge
    
        public Edge(VertexInterface<T> endVertex) {
            vertex = endVertex;
        } //end constructor
    
        public VertexInterface<T> getVertex() {
            return vertex;
        } //end getVertex
    } //end Edge

    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return new NeighborIterator();
    }

    private class NeighborIterator implements Iterator<VertexInterface<T>> {
        private Iterator<Edge> edges;

        private NeighborIterator() {
            edges = edgeList.iterator();
        }

        public boolean hasNext() {
            return edges.hasNext();
        }

        public VertexInterface<T> next() {
            VertexInterface<T> nextNeighbor = null;
            if (edges.hasNext()) {
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getVertex();
            } else
                throw new NoSuchElementException();
            return nextNeighbor;
        }
    }
}
