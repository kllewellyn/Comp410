package main;

public class AssnBinHeap {

	  public static void main (String[] args) {
	   MinBinHeap test = new MinBinHeap(new EntryPair("hello", 3));
	   MinBinHeap test1 = new MinBinHeap();
	   test.insert(new EntryPair("it's", 5));
	   test.insert(new EntryPair("me", 1));
	//   test.print();
	//   System.out.println("yayyyy");
	   test.insert(new EntryPair("how are you?", 6));
	//   test.print();
	//   System.out.println("hello");
	   test.insert(new EntryPair("yas", 2));
	   test.print();
	   
	   System.out.println(" ");
	   EntryPair[] songs = new EntryPair[5];
	   songs[0] = new EntryPair("hello", 3);
	   songs[1] = new EntryPair("it's", 5);
	   songs[2] = new EntryPair("me", 1);
	   songs[3] = new EntryPair("how are you?", 6);
	   songs[4] = new EntryPair("yas", 2);
	   
	   test1.build(songs);
	   test1.print();
	   
	   

	  }

	  // anything else you need to add in
	}