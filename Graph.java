
import java.util.Iterator;

public class Graph<E> implements GraphInterface<E> {
    
    private boolean[][] edges; //edges[i][j] is true if there is a vertex from i to j
    private E[] labels; //labels[i] contains the label for vertex i
    private DictionaryInterface<E, VertexInterface<E>> vertices;


    //constructor
    public Graph(int n) {
        edges = new boolean[n][n]; //all values initially false
        labels = (E[]) new Object[n]; //all values initally null
        vertices = new LinkedDictionary();
    }

    //accessor method to get the label of a vertex of this graph
    public E getLabel(int vertex){ 
        return labels[vertex];
    }

    //test whether an edge exists
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    //add an edge
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    //obtain a list of neighbors of a specified vertex of this graph
    public int[] neighbors(int vertex) {
        int count = 0;
        int[] answer;

        for(int i = 0; i < labels.length; i++) {
            if(edges[vertex][i])
                count++;
        }

        answer = new int[count];
        count = 0;
        for (int i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }

    //remove an edge
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    //change the label of a vertex of this graph
    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }

    //checks if the vertices are empty
    public boolean isEmpty() {
        return labels.length == 0;
    }

    public int size() {
        return labels.length;
    }

    //checks how many edges there are
    public int getNumberOfEdges() {
        return edges.length;
    }

    //clears both the edges and the label arrays
    public void clear() {
        for (int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges.length; j++) {
                edges[i][j] = false;
            }
        }

        for (int i = 0; i < labels.length; i++) {
            labels[i] = null;
        }
        
    }
    protected void resetVertices() {
        Iterator<VertexInterface<E>> vertexIterator = vertices.getValueIterator();
        while(vertexIterator.hasNext()) {
            VertexInterface<E> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
        } //end while
    } //end resetVertices


    //slide 97
    public QueueInterface<E> getBreadthFirstTraversal(E origin) {
        resetVertices();
        QueueInterface<E> traversalOrder = new LinkedQueue<E>();
        QueueInterface<VertexInterface<E>> vertexQueue = new LinkedQueue<VertexInterface<E>>();

        VertexInterface<E> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin); //enqueue vertex label
        vertexQueue.enqueue(originVertex); //enqueue vertex

        while(!vertexQueue.isEmpty()) {
            VertexInterface<E> frontVertex = vertexQueue.dequeue();

            Iterator<VertexInterface<E>> neighbors = frontVertex.getNeighborIterator();

            while(neighbors.hasNext()) {
                VertexInterface<E> nextNeighbor = neighbors.next();
                if(!nextNeighbor.isVisited()) {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                } //end if
            }//end while
        }//end while
        return traversalOrder;
    }//end getBreadthFirstTraversal


    public QueueInterface<E> getDepthFirstTraversal(E origin) {
        //assumes graph is not empty
        resetVertices();
        QueueInterface<E> traversalOrder = new LinkedQueue<E>();
        StackInterface<VertexInterface<E>> vertexStack = new LinkedStack<>();

        VertexInterface<E> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin); //enqueue vertex label
        vertexStack.push(originVertex); //enqueue vertex

        while(!vertexStack.isEmpty()) {
            VertexInterface<E> topVertex = vertexStack.peek();
            VertexInterface<E> nextNeighbor = topVertex.getUnvisitedNeighbor();

            if(nextNeighbor != null) {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else //all neighbors are visited
                vertexStack.pop();
        }// end while
        return traversalOrder;
    }

    //slide 116 for depthfirsttraversal
}
