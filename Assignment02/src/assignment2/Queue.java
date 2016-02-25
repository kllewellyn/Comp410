package assignment2;

public class Queue{

	public ListInterface queue;

	public Queue(boolean k)
	{
		if(k)
			queue = new ListLinked();
		else
			queue = new ListArray();
	}
	
	public Queue()
	{
		this(true);
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
