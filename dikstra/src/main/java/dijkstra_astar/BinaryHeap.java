package dijkstra_astar;

import dijkstra_astar.DNode;

//BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// boolean isFull( )      --> Return true if full; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws Overflow if capacity exceeded

/**
 * Implements a binary heap. Note that all "matching" is based on the compareTo
 * method.
 * 
 * @author Mark Allen Weiss
 */
public class BinaryHeap {
	/**
	 * Construct the binary heap.
	 */
	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Construct the binary heap.
	 * 
	 * @param capacity
	 *            the capacity of the binary heap.
	 */
	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = new Comparable[capacity + 1];
	}

	/**
	 * Insert into the priority queue, maintaining heap order. Duplicates are
	 * allowed.
	 * 
	 * @param x
	 *            the item to insert.
	 * @exception Overflow
	 *                if container is full.
	 */
	@SuppressWarnings("unchecked")
	public void insert(Comparable x) throws Exception {
		if (isFull())
			throw new Exception("Overflow error");

		// Percolate up
		int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2){
			
			array[hole] = array[hole / 2];
		}
			
		
		array[hole] = x;
		
		//hier heap Index zuweisen
		
		 
		Comparable whattheheck = array[hole];
		
		DNode node = (DNode)x;
		
		node.heapIndex = hole;
		
		
	}

	/**
	 * Find the smallest item in the priority queue.
	 * 
	 * @return the smallest item, or null, if empty.
	 */
	public Comparable findMin() {
		if (isEmpty())
			return null;
		return array[1];
	}

	/**
	 * Remove the smallest item from the priority queue.
	 * 
	 * @return the smallest item, or null, if empty.
	 */
	public Comparable deleteMin() {
		if (isEmpty())
			return null;

		Comparable minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);

		return minItem;
	}

	/**
	 * Establish heap order property from an arbitrary arrangement of items.
	 * Runs in linear time.
	 */
	public void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--)
			percolateDown(i);
	}

	/**
	 * Test if the priority queue is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return currentSize == 0;
	}

	/**
	 * Test if the priority queue is logically full.
	 * 
	 * @return true if full, false otherwise.
	 */
	public boolean isFull() {
		return currentSize == array.length - 1;
	}

	/**
	 * Make the priority queue logically empty.
	 */
	public void makeEmpty() {
		currentSize = 0;
	}

	private static final int DEFAULT_CAPACITY = 100;

	private int currentSize; // Number of elements in heap
	private Comparable[] array; // The heap array

	/**
	 * Internal method to percolate down in the heap.
	 * 
	 * @param hole
	 *            the index at which the percolate begins.
	 */
	private void percolateDown(int hole) {
		int child;
		Comparable tmp = array[hole];

		for (; hole * 2 <= currentSize; hole = child) {
			
			child = hole * 2;
			if (child != currentSize && array[child + 1].compareTo(array[child]) < 0){
				child++;
			}
			if (array[child].compareTo(tmp) < 0){
				array[hole] = array[child];
			}else{
				break;
			}
				
		}
		
		
		array[hole] = tmp;
		((DNode) array[hole]).heapIndex=hole;
	}
	
	
	
	/**
	 * Internal method to rise elements up in the heap.
	 * 
	 * @param hole
	 *            the index of the element being checked if its rising
	 *            runs in linear time
	 */
	
	@SuppressWarnings("unchecked")
	public void rise(int hole){
		
		if(hole>=2){
			
			for(int parent=(hole/2);parent>0 && array[parent].compareTo(array[hole])==(1); parent/=2){
				percolateDown(parent);
				hole/=2;
			}	

		}
		
	}

	// Test program
	public static void main(String[] args) {
		int numItems = 100;
		BinaryHeap h = new BinaryHeap(numItems);
		int i = 37;

		try {
			for (i = 37; i != 0; i = (i + 37) % numItems) {
				h.insert(new MyInteger(i));
			}
			for (i = 1; i < numItems; i++)
				System.out.print(" " + ((MyInteger) h.deleteMin()).value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}