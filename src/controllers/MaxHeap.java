package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxHeap implements MaxHeapInterface{
     
		private ArrayList<Item> items;
		
		public MaxHeap(){
			
			items = new ArrayList<Item>();
	
		}
		
	//// code from video class notes
private void siftUp(){
	int k = items.size()-1;
	while (k > 0){
		int p = (k-1)/2;
		Item item = items.get(k);
		Item  parent = items.get(p);
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
			Item temp = items.get(k);
			items.set(k, items.get(max));
			items.set(max, temp);
			k = max;
			l = 2*k+1;
		} else{
			break;
		}
	}
}//end of siftDown



public boolean find(String temp){

	int k=0;
	int current = k;
	int l=current*2+1;
	int r = l+1;


 Iterator<Item> find = items.iterator();
 	while(find.hasNext()){
	if(getItem(current).getSpanish().equals(temp)){
		System.out.println("Answer From Depth Search of Heap =    " + getItem(current).getEnglish());
		return true;
	}
	else if((getItem(current).getSpanish().compareTo(temp)   >  1)){
	
		current = current*2+1;
	} 
	else {
		current = current*2+2;
	}

 	}
	return false;
}

	





public String toString(){
	return items.toString();
}



@Override
public void add(Item newEntry) {
	items.add(newEntry);
	siftUp();
	
}


@Override
public boolean isEmpty() {
	return items.isEmpty();
}

public Item getItem(int i){
	return items.get(i);
	
}

@Override
public int getSize() {
	return items.size();
}


@Override
public void clear() {

	}
	


@Override
public Item removeMax()throws NoSuchElementException {
	System.out.println("Item that has been removed :  " + items.get(0));
	if(items.size() == 0){
		throw new NoSuchElementException();
	}
	if(items.size()==1){
	 items.remove(0);
	 
	}
	Item hold = items.get(0);
	items.set(0, items.remove(items.size()-1));
	siftDown();
	return hold;
	
}

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