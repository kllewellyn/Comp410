package assignment2;

public class Cell {

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
