package a3;

import java.util.*;

public class Assn3Main {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();	
		Scanner keyboard = new Scanner(System.in);
		String input;
		if (args.length==0)
		{
			System.out.println("mode 1");
			System.out.println("we will do the interactive test driver");
			System.out.println("Enter a command: ");
			input = keyboard.next();
			while(!input.equals("q")){
				switch(input)
				{
				case "new": 
					bst = new BinarySearchTree();
					break;
				case "i": 
					System.out.println("Input String: ");
					bst.insert(keyboard.next());
					break;
				case "r":
					System.out.println("Input string to remove: ");
					bst.remove(keyboard.next());
					break;
				case "c":
					System.out.println("Input string for contains: ");
					System.out.println(bst.contains(keyboard.next()));
					break;
				case "g":
					System.out.println("Input String to get: ");
					System.out.println(bst.get(keyboard.next()).val);
					break;
				case "x":
					System.out.println(bst.findMax());
					break;
				case "n":
					System.out.println(bst.findMin());
					break;
				case "v":
					System.out.println(bst.val());
					break;
				case "e":
					System.out.println(bst.empty());
					break;
				case "s":
					System.out.println(bst.size());
					break;
				case "h":
					System.out.println(bst.height());
					break;
				case "q": return;
				case "p":
					bst.print();
					break;
				}
				System.out.println("Enter a command: ");
				input = keyboard.next();
			}
		}
		else{
			String cmd;
		    System.out.println("mode 2");
			System.out.println("here are the args: \n");
			int na = args.length;
			for (int i = 0; i < na; i++)
			{
				cmd = args[i];
				System.out.println("command: " + cmd);
				switch(cmd)
				{
				case "new": 
					bst = new BinarySearchTree();
					break;
				case "i": 
					bst.insert(args[++i]);
					System.out.println("The string: \"" + args[i] + "\" was inserted.");
					break;
				case "r":
					bst.remove(args[++i]);
					System.out.println("The string: \"" + args[i] + "\" was removed.");
					break;
				case "c":
					System.out.println(bst.contains(args[++i]));
					System.out.println("Test of if the string: \"" + args[i] + "\" was contained.");
					break;
				case "g":
					System.out.println(bst.get(args[++i]));
					System.out.println("Got the node with val: \"" + args[i] + "\".");
					break;
				case "x":
					System.out.println(bst.findMax());
					break;
				case "n":
					System.out.println(bst.findMin());
					break;
				case "v":
					System.out.println(bst.val());
					break;
				case "e":
					System.out.println(bst.empty());
					break;
				case "s":
					System.out.println(bst.size());
					break;
				case "h":
					System.out.println(bst.height());
					break;
				case "q": return;
				case "p":
					bst.print();
					break;
				}
				}
				System.out.println();
			}
			System.out.println();
		}


	}

	//Node class code
	class Node {
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


//Binary Search Tree Interface code
interface BST {	
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


//Binary Search Tree code
class BinarySearchTree implements BST{

	Node root, current, parent;
	int size = 0;

	public BinarySearchTree(){
		root = null;
	}

	@Override
	public void insert(String s) {
		if (root == null){
			root = new Node(s);
			size++;
		}
		else{
			insertR(s, root);
		}
	}

	public void insertR(String s, Node r){
		Node current = r;
		if(s.compareToIgnoreCase(current.val) > 0)
		{
			parent = current;
			current = current.right;
			if(current == null)
			{
				parent.right = new Node(s, parent);
				size++;
			}
			else{
				insertR(s, current);
			}
		}
		else if(s.compareToIgnoreCase(current.val) < 0){
			parent = current;
			current = current.left;
			if(current == null)
			{
				parent.left = new Node(s, parent);
				size++;
			}
			else{
				insertR(s, current);
			}
		}

	}

	@Override
	public void remove(String s) {
		if(contains(s)){
			removeR(get(s));
			size--;
		}
	}


	public void removeR(Node e){
		Node tempParent = e.parent;
		if(tempParent == null){
			String temp = findMin(e.right);
			removeR(get(findMin(e.right)));
			e.val = temp;
			
		}
		else if(e.left == null && e.right == null){
			if(tempParent.left == e){
				tempParent.left = null;
			}
			else
				tempParent.right = null;
		}
		else if(e.left != null && e.right != null){
			e.val = findMin(e.right);
			removeR(e.right);
		}
		else if(e.left!= null){
			if (tempParent.left == e){
				tempParent.left = e.left;
			}
			else{
				tempParent.right = e.left;
			}
		}
		else{
			if(tempParent.left == e){
				tempParent.left = e.right;
			}
			else{
				tempParent.right = e.right;
			}
		}
	}

	@Override
	public String findMax() {
		current = root;
		while(current.right != null)
		{
			current = current.right;
		}
		return current.val;
	}

	@Override
	public String findMin() {
		current = root;
		while(current.left != null)
		{
			current = current.left;
		}
		return current.val;
	}

	public String findMin(Node n){
		current = n;
		while(current.left != null)
		{
			current = current.left;
		}
		return current.val;
	}

	@Override
	public boolean contains(String s) {
		if(get(s) == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public Node get(String s) {
		current = root;

		while(current != null){
			if(s.compareToIgnoreCase(current.val) < 0){
				current = current.left;
			}
			else if(s.compareToIgnoreCase(current.val) > 0){
				current = current.right;
			}
			else if(s.compareToIgnoreCase(current.val) == 0)
			{
				break;
			}
			else
				current = null;
		}

		return current;

	}

	@Override
	public String val() {
		return root.val;
	}

	@Override
	public boolean empty() {
		if(root==null){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	public int height(){
		current = root;
		return heightR(current);
	}

	@Override
	public int heightR(Node n) {
		if(n == null){
			return 0;
		}
		return 1 + Math.max(heightR(n.right), heightR(n.left));
	}

	public void print(){
		if(root != null){
			String spaces = "";
			printR(root, spaces);
		}
	}

	public void printR(Node r, String s){
		if(r != null){
			System.out.println(s + r.val);
			s += "    ";
			printR(r.left, s);
			printR(r.right, s);
		}	
	}

}

