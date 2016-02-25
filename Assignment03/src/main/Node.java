package main;

public class Node {
	
	Node left, right, parent;
	String val;
	
	public Node(String input){
		val = input;
	}
	
	public Node(String input, Node parentInput){
		val = input;
		parent = parentInput;
	}
	
	public String getVal(){
		return val;
	}
	
	public Node getParent(){
		return parent;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	
	

}
