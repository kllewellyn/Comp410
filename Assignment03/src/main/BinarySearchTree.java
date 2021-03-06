package main;

public class BinarySearchTree implements BST{

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
		}
	}
	
	
	public void removeR(Node e){
		size--;
		Node tempParent = e.parent;
		if(tempParent == null){
			e.val = findMin(e.right);
			removeR(e.right);
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
