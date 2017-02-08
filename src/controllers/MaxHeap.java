package controllers;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MaxHeap <T extends Comparable<T>> implements MaxHeapInterface<T>{
     
		private ArrayList<T> items;
		
		public MaxHeap(){
			
			items = new ArrayList<T>();
	
		}

		
	//// code from video class notes
private void siftUp(){
	int k = items.size()-1;
	while (k > 0){
		int p = (k-1)/2;
		T item = items.get(k);
		T parent = items.get(p);
		if(item.compareTo(parent) > 0){
			//swap
			items.set(k, parent);
			items.set(p, item);
			
			//move up one level
			k = p;
		} else{
			break;
			
		}
	}
}










// code from video class notes
private void siftDown(){
	int k = 0;
	int l = 2*k+1;
	while(l < items.size()) {
		int max =l, r=l+1;
		if(r < items.size()) { // there is a right child
			if(items.get(r).compareTo(items.get(l)) > 0) {
				max++;
			}
		}
		if (items.get(k).compareTo(items.get(max)) < 0) {
			// switch
			T temp = items.get(k);
			items.set(k, items.get(max));
			items.set(max, temp);
			k = max;
			l = 2*k+1;
		} else{
			break;
		}
	}
}//end of siftDown


public String toString(){
	return items.toString();
}



@Override
public void add(T newEntry) {
	items.add(newEntry);
	siftUp();
	
}


@Override
public boolean isEmpty() {
	return items.isEmpty();
}


@Override
public int getSize() {
	return items.size();
}


@Override
public void clear() throws NoSuchElementException {
		if(items.size() == 0){
			throw new NoSuchElementException();
		}
		if(items.size()==1){
		 items.remove(0);
		}
		//T hold = items.get(0);
		items.set(0, items.remove(items.size()-1));
		siftDown();
		System.out.println(items.size());
		
	}
	


@Override
public T removeMax()throws NoSuchElementException {
	if(items.size() == 0){
		throw new NoSuchElementException();
	}
	if(items.size()==1){
	 items.remove(0);
	}
	T hold = items.get(0);
	items.set(0, items.remove(items.size()-1));
	siftDown();
	return hold;
	
}

@Override
public T getMax() {
	
T root = null;
    
    if (!isEmpty())
      root = items.get(0);
      
    return root;
} 
	
	
	
}