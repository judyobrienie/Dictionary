package controllers;

import java.util.ArrayList;

import java.util.NoSuchElementException;
/**
 * @author Judy
 * @param A MaxHeap Class 
 * Create a MaxHeap from Array List of 'Items' 
 */
public class MaxHeap implements MaxHeapInterface {

	private ArrayList<Item> items;
	int count = 0;

	public MaxHeap() {

		items = new ArrayList<Item>();

	}

	/**
	 * Code from video class notes
	 * @param compares two items and moves the the higher value up 
	 * @returns a sorted heap branch based on implemented comparator
	 * 
	 */
	
	private void siftUp() {
		int k = items.size() - 1;
		while (k > 0) {
			int p = (k - 1) / 2;
			Item item = items.get(k);
			Item parent = items.get(p);
			if (item.compareTo(parent) > 0) {

				// swap
				items.set(k, parent);
				items.set(p, item);

				// move up one level
				k = p;
			} else {
				break;

			}
		}
	}

	/**
	 * Code from video class notes
	 * @param compares two items and moves the lower value down
	 * @return a sorted heap branch based on implemented comparator
	 * 
	 */
	
	
	private void siftDown() {
		int k = 0;
		int l = 2 * k + 1;
		while (l < items.size()) {
			int max = l, r = l + 1;
			if (r < items.size()) { // there is a right child
				if (items.get(r).compareTo(items.get(l)) > 0) {
					max++;
				}
			}
			if (items.get(k).compareTo(items.get(max)) < 0) {
				// switch
				Item temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				k = max;
				l = 2 * k + 1;
			} else {
				break;
			}
		}
	}// end of siftDown
	
	
	/**
	 * 
	 * @param 'temp' an item 'key' that you want to search the heap for
	 * @return returns the 'value' of that key
	 */

	public String find3(String temp) {

		return find4(temp, 0,0);
	}
	
/**
 * @param temp an item to search for and i the index where to search
 * @return true/false Printing out the the value of the matching item for temp
 * ******************Code with Alex help from class****************************
 */
	public String find4(String temp, int i,int step) {
		 step++;
		 String left = null;
		 String right = null;
		if(i >= items.size()) return null;
		if (getItem(i).getSpanish().equals(temp)){
			

			System.out.println("Answer From Depth Search of Heap =    " + getItem(i).getEnglish());
			System.out.println("No of Traversals :  " + count);
            
            System.out.println("No of Steps = " + step);   //code from Alex
			return getItem(i).getEnglish();

		}
		else if ((getItem(i).getSpanish().compareTo(temp) > 0 )) {
			count++;
			int l = 2 * i + 1;
			left = find4(temp, l,step);
			int r = 2 * i + 2;
			right = find4(temp, r,step);
		}else
			return null;
		if(left == null) return right;
		return left;
	}
	
	
	
	

	/**
	 * 
	 * @param 'temp' an item 'key' that you want to search the heap for
	 * @return returns the 'value' of that key
	 */

	public Boolean find(String temp) {

		return find2(temp, 0);
	}
	
	
	/**
	 * @param temp an item to search for and i the index where to search
	 * @return true/false Printing out the the value of the matching item for temp
	 * 
	 */

	
	 public boolean find2(String temp, int i) {
		
		 
		 boolean find= false;
		 
		if (getItem(i).getSpanish().equals(temp)){

			System.out.println("Answer From Depth Search of Heap =    " + getItem(i).getEnglish());
			System.out.println("No of Traversals :  " + count);
			
            
            find = true;
			return true;
			
		}
		
		if ((getItem(i).getSpanish().compareTo(temp) > 0 && find)); {
			count++;
			int l = 2 * i + 1;
			if (l < items.size() ? find2(temp, l):  false);
			
			int r = 2 * i + 2;
			if (r < items.size() ? find2(temp, r): false);
				
		
		}//end else if	
		
		
		return false;
	}

	
	

/**
 * A method to return a string representation 
 * @return a string representation
 */

	public String toString() {
		return items.toString();
	}

	/**
	 * A method to add a new entry to a heap
	 * @param newEntry and entry from a user 
	 */
	
	@Override
	public void add(Item newEntry) {
		items.add(newEntry);
		siftUp();
	}

	/**
	 * A method to check if heap is empty
	 * @param True or False
	 */
	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	
	/**
	 * @return an item at index i
	 */
	public Item getItem(int i) {
		return items.get(i);

	}

	/**
	 * @return the size of the array of items
	 */
	@Override
	public int getSize() {
		return items.size();
	}

	/**
	 * A method  to remove the item at the top of the heap
	 * which is at index 0
	 */

	@Override
	public Item removeMax() throws NoSuchElementException {
		System.out.println("Item that has been removed :  " + items.get(0));
		if (items.size() == 0) {
			throw new NoSuchElementException();
		}
		if (items.size() == 1) {
			items.remove(0);
			

		}
		Item hold = items.get(0);
		items.set(0, items.remove(items.size() - 1));
		siftDown();
		return hold;

	}

	/**
	 * A method to return an item at the top of the heap
	 * which is at index 0
	 * @return item at top of heap which is at index 0
	 */
	@Override
	public Item getMax() {

		Item root = null;

		if (!isEmpty())
			root = items.get(0);

		return root;
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

}