

/**An interface of methods providing basic operations
 * for directied and undirected graphs that are either weighted 
 * or unweighted
 */
public interface GraphInterface<T> {


    /**Adds a given vertex to thsi graph
     * @param vertex the vertex of which label is changing
     * @param newLabel the new label for that vertex
     */
    public void setLabel(int vertex, T newLabel);

    /**Adds an edge to the end of a vertex
     * @param source the vertex to which the edge is being added
     * @param target the end vertex to which the edge is connecting
     */
    public void addEdge(int source, int target);

    /**Sees whether an edge exists between two verticex
     * @param source An object that lebls the origin vertex of the edge
     * @param target An objects that lebls the end vertex of the edge
     */
    public boolean isEdge(int source, int target);

    /**Checks whether the graph is empty
     * @return True if the graph is empty
     */
    public boolean isEmpty();

    /**Gets the number of vertices in the graph
     * @return the number of vertices
     */
    public int size();

    /**Gets the number of edges in this graph
     * @return the number of edges
     */
    public int getNumberOfEdges();

    /**clears the graph of all edges and vertices */
    public void clear();

    /**Performs a breadth-first traversal of this graph
     * @param origin An objects that labels the origin vertex of the traversel
     * @return a queue of labels fo the vertices in the traversal,
     * with the label of the origin vertex at the queue's front
     */
    public QueueInterface<T> getBreadthFirstTraversal(T origin);

    /**Performs a depth-first traversal of this graph
     * @param origin An objects that labels the origin vertex of the traversel
     * @return a queue of labels fo the vertices in the traversal,
     * with the label of the origin vertex at the queue's front
     */
    public QueueInterface<T> getDepthFirstTraversal(T origin);

    

}