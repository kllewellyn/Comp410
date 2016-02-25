package assignment2;

public class BridgeQueueListDemo {

	
	
	class Cell {

		String val;
		Cell next = null;

		public Cell(String s) {
			val = s;
		}

		public String getVal()
		{
			return val;
		}
		
		public Cell getNext() {
			return next;
		}
	}
	
	class Queue {   
	   protected ListImp imp;     
	   public Queue( String iType ) { 
	      if(iType.equals("array")){
	    	  ListImp ListArray = new ListImpArray();
	      }
	      else
	      {
	    	  ListImp ListLinked = new ListImpLinks();
	      }
	   }
	   public Queue() { 
	 
	   }
	   public ListInterface queue;

		public Queue(boolean k)
		{
			if(k)
				queue = new ListLinked();
			else
				queue = new ListArray();
		}
		
		public void New()
		{
			queue.New();
		}
		
		public int size()
		{
			return queue.size();
		}
		
		public boolean empty()
		{
			return queue.empty();
		}
		
		public String front()
		{
			return queue.get(0);
		}
		
		public void enq(String s)
		{
			queue.ins(s,queue.size());
		}
		
		public ListInterface deq()
		{
			queue.remove(0);
			return queue;
		}
	}


	//=== Implementation side =======================================
	// one of these is hooked into each front end object

	interface ListImp {  
		public Object New();
		public void ins(String s, int i);
		public void remove(int i);
		public String get(int i);
		public int size();
		public boolean empty();
	}

	class ListImpLinks implements ListImp { 
		Cell head;
		Cell temp;
		int size;
		
		public ListImpLinks()
		{
			head = null;
			size = 0;
		}

		public ListInterface New()
		{
			return new ListLinked();
		}
		
		@Override
		public void ins(String s, int i) {
			if(head == null)
			{
				head = new Cell(s);
				size++;
			}
			else{
				Cell current = getCell(i);
				temp = current.next;
				(current.next).next = temp;
				size++;
			}
		}

		@Override
		public void remove(int i) {
			if(i == 0)
			{
				head = head.next;
				size --;
			}
			else{
				Cell current = getCell(i - 1);
				current.next = (current.next).next;
				size--;
			}
		}

		@Override
		public String get(int i) {
			
			return getCell(i).getVal();
			
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean empty() {
			if(head == null)
				return true;
			else 
				return false;
		}
		
		public Cell getCell(int i)
		{
			Cell current = head;
			for(int k = 0; k < i; k++){
				current = current.next;
			}
			return current;
		}
	}

	class ListImpArray implements ListImp { 
		protected String[] list;
		protected int MAX = 200;
		protected int size = 0;
		
		public ListImpArray(){
			list = new String[MAX];
		}
		
		public ListInterface New()
		{
			return new ListArray();
		}
		
		@Override
		public void ins(String s, int i) {
			for(int p = size+1; p >= i; p--)
			{
				list[p] = list[p-1];
			}
			list[i] = s;
			size++;
		}

		@Override
		public void remove(int i) {
			for(int p = i; i < size; i++)
			{
				list[p] = list[p+1];
			}
			size--;
		}

		@Override
		public String get(int i) {
			return list[i];
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean empty() {
			if(size == 0)
				return true;
			else
				return false;
		}
	}


	//==== client code =================================================
	// this is the test framework where you make some queues
	// and exercise them
	// our goal is for each to behave the same regardless
	// of the way the LIST is implemented

	class BridgeQueueListDemo {

	  public static void main( String[] args ) {

	  


	  }
	  
	}

}
