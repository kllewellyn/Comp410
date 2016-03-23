package main;

public class AssnBinHeap {

	  public static void main (String[] args) {
	   MinBinHeap test = new MinBinHeap(new EntryPair("hello", 3));
	   
	   test.insert(new EntryPair("it's", 5));
	   test.insert(new EntryPair("me", 1));
	   test.print();

	  }

	  // anything else you need to add in
	}