package main;

public interface BST {
	
	public void insert(String s);
	public void insertR(String s, Node r);
	public void remove(String s);
	public String findMax();
	public String findMin();
	public boolean contains(String s);
	public Node get(String s);
	public String val();
	public boolean empty();
	public int size();
	public int height();
	public int heightR(Node n);
	public void print();
	public void printR(Node n, String s);
	

}
