package controllers;

public interface MaxHeapInterface extends Comparable<Item>
{
    /** Task: Adds a new entry to the heap.
    * @param newEntry an object to be added */
    public void add ( Item newEntry);
    
    /** Task: Removes and returns the largest item in the heap.
    * @return either the largest object in the heap or,
    * if the heap is empty before the operation, null */
    public Item removeMax ();
    
    /** Task: Retrieves the largest item in the heap.
    * @return either the largest object in the heap or,
    * if the heap is empty, null */
    public Item  getMax ();
    
    /** Task: Detects whether the heap is empty.
    * @return true if the heap is empty, else returns false */
    public boolean isEmpty ();
    
    /** Task: Gets the size of the heap.
    * @return the number of entries currently in the heap */
    public int getSize ();
    
   
    
} // end MaxHeapInterface