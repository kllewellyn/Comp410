package assignment2;

public class ListLinked implements ListInterface{
	
	Cell head;
	Cell temp;
	int size;
	
	public ListLinked()
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
