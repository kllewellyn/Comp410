package main;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		SplayTree bst = new SplayTree();	
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
					bst = new SplayTree();
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
					bst = new SplayTree();
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
