package assn6;

public class Edge {
	
	Node front, back;
	long weight, id;
	String elabel;
	
	public Edge(long idNum, Node b, Node f, String label, long w){
		id = idNum;
		weight = w;
		front = f;
		back = b;
		elabel = label;
	}

}
