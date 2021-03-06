package BridgeQueueListDemo;

public class BridgeQueueListDemo {
public static void main(String[] args) {
		
		Queue ArrayListQueue = new Queue(false);
		Queue LinkedListQueue = new Queue(true);
		
		LinkedListQueue.enq(args[0]);
		ArrayListQueue.enq(args[0]);
		
		System.out.println(LinkedListQueue.size());
		System.out.println(ArrayListQueue.size());
		
		System.out.println(LinkedListQueue.front());
		System.out.println(ArrayListQueue.front());
		
		LinkedListQueue.deq();
		ArrayListQueue.deq();
		
		System.out.println(LinkedListQueue.size());
		System.out.println(ArrayListQueue.size());
		
		for(int i = 0; i < args.length; i++){
			LinkedListQueue.enq(args[i]);
			ArrayListQueue.enq(args[i]);
		}
		
		for(int k = 0; k < args.length-1; k++){
			System.out.println(LinkedListQueue.front());
			System.out.println(ArrayListQueue.front());
			
			LinkedListQueue.deq();
			ArrayListQueue.deq();
			
			System.out.println(LinkedListQueue.size());
			System.out.println(ArrayListQueue.size());
		}
		
		
	}
}

interface ListInterface {
	public void ins(String s, int i);
	public void remove(int i);
	public String get(int i);
	public int size();
	public boolean empty();	
}

class Cell {

	String val;
	Cell next;

	public Cell(String s) {
		next = null;
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

	class Queue{

		protected ListInterface queue;
		int front = 0, back = 0;

		public Queue(boolean k)
		{
			if(k)
				queue = new ListLinked();
			else
				queue = new ListArray();
		}
		
		public Queue(){}
		
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
			return queue.get(front);
		}
		
		public ListInterface enq(String s)
		{
			queue.ins(s,back);
			back++;
			return queue;
		}
		
		public ListInterface deq()
		{
			queue.remove(front);
			back --;
			return queue;
		}

	}
	
	class ListArray implements ListInterface{

		protected String[] list;
		protected int MAX = 100;
		protected int size = 0;
		
		public ListArray(){
			list = new String[MAX];
		}
		
		
		@Override
		public void ins(String s, int i) {
			if(size == 0){
				list[size] = s;
				size++;
			}
			else if(i == size){
				list[i] = s;
				size++;
			}
			else{
				for(int p = size+1; p > 0; p--)
				{
					list[p] = list[p-1];
				}
				list[i] = s;
				size++;
			}
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
	
	class ListLinked implements ListInterface{
		
		Cell head, temp;
		int size;
		
		public ListLinked()
		{
			head = null;
			size = 0;
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
			for(int k = 0; k < i-1; k++){
				current = current.next;
			}
			return current;
		}
		
	}

