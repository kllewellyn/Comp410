package assn6;

public class AssnTopoSort {

	  public static void main (String[] args) {
	   
		  DiGraph test = new DiGraph();
		  test.addNode(0, "hello");
		  test.addNode(1, "yoohoo");
		  test.addEdge(0, "hello", "yoohoo", 1, "tester");
		  test.print();
		  System.out.println("");
		  test.delNode("hello");
		  test.print();
		 
		 
	  }

	  // anything else you need to add in
	}