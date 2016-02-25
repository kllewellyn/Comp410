package assignment2;

public class ListArray implements ListInterface{

	protected String[] list;
	protected int MAX = 200;
	protected int size = 0;
	
	public ListArray(){
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
