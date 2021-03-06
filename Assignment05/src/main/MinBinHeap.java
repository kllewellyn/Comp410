package main;

public class MinBinHeap implements HeapInterface {

	  // in here go all your data and methods for the heap

	int size, current, end, parent;
	EntryPair root;
	EntryPair[] heap;
	
	  public MinBinHeap ( ) { // default constructor
	    // explicitly include this
	    // we need to have the default constructor
	    // if you then write others, this one will still be there
		  size = 0;
		  end = 1;
		  heap = new EntryPair[1000];
	  }
	  
	public MinBinHeap(EntryPair e){
		heap = new EntryPair[100];
		root = e;
		end = 1;
		heap[end] = e;
		end++;
		size = 1;
		
	}

	@Override
	public void insert(EntryPair entry) {
		
		if(size == 0){
			heap[end] = entry;
			end++;
			size++;
		}
		else if (size >= 1)
		{
			size++;
			heap[end] = entry;
			end++;
		}
		current = end -1 ;
		parent = current;
		while( parent > 1){
			if(heap[current].getPriority() < heap[current/2].getPriority()){
			EntryPair temp = new EntryPair();
			temp = heap[current];
			heap[current] = heap[current/2];
			heap[current/2] = temp;
			}
			current = current/2;
			if(current == 1){
				root = heap[current];
			}
			parent = current/2;
//			 System.out.println(parent);
		}
		
	}

	@Override
	public void delMin() {
		heap[1] = null;
		size--;
	}

	@Override
	public EntryPair getMin() {
		return root;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		for(int i = 0; i < entries.length; i++){
			insert(entries[i]);
		}
	}
	
	public void print(){
		for(int i = 1; i <= size(); i++){
			System.out.println(heap[i].getPriority());
		}
	}
	}