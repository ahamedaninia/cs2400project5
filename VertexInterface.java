
import java.util.Iterator;

public interface VertexInterface<T> {
    /**Gets this vertex's label
     * @return The object that labels the vertex
     */
    public T getLabel();

    /**Marks this vertex as visited */
    public void visit();

    /**Removes this vertex's visited mark */
    public void unvisit();

    /**Sees whether thsi vertex is marked as visited
     * @return True if the vertex is visited
     */
    public boolean isVisited();

    /**Creates an iterator of this vertex's neighbors
     * by following all the edges that begin at this vertex
     * @return An iterator of the neioghboring vertices of this vertex
     */
    public Iterator<VertexInterface<T>> getNeighborIterator();

    /**Sees whether this vertex has at least one neighbor
     * @return True if the vertex has a neighbor
     */
    public boolean hasNeighbor();

    /**Gets an unvisited neighbor, if any, of this vertex
     * @return Either a vertex that is an univsiited neighbor,
     * or null if no such neighbor exists
     */
    public VertexInterface<T> getUnvisitedNeighbor();
}