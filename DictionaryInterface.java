import java.util.Iterator;

/**
 * An interface for a dictionary with distinct search keys
 * Search keys and associated values are not null
*/

 public interface DictionaryInterface<K, V> {
    /**Adds a new entry to this dictionary. If the search key
     * already exists, replaces corresponding value.
     * @param key An opbject serch key of the new entry
     * @param value An object associated with the search key
     * @return Either null if the new entry was added or value was replaced
     */
    public V add(K key, V value);

    /**Removes a specific entry from this dictionary
     * @param ket An object search key of the entry to be removed
     * @return Either the value that was associated with the search key
     * or null if no such object exists
     */
    public V remove(K key);

    /**Retrives from this dictionary the value assicoated with  a given
     * @param key An object search key of the entry to be retrived
     * @return Eitherh the value that is associated with the search key
     * or null if no such object exists
     */
    public V getValue(K key);

    /**Sees whether a specific entry is in this dictonary
     * @param key An object search key of the desired entry
     * @return True iof the key is assicoated with an entry in the dictionary
     */
    public boolean contains(K key);

    /**Creates an iteratiore that traverses all values in this dictionary
     * @return An iterator that provides sequential access to the values in this dictionary
     */
    public Iterator<V> getValueIterator();

    /**Sees whether the dictionary is empty
     * @return True if the dictionary is empty
     */
    public boolean isEmpty();

    /**Gets the size of the dictionary
     * @return The number of entries (key-value pairs) currently in the dictionary
     */
    public int getSize();

    /**Removes all entries from this dictinary */
    public void clear();


} //end DictionaryInterface
