import java.util.Scanner;

public class RevengeOfPancakes {

	static int smiley;
	static int blank;
	static int flipNumbers;
	
	public static void main(String[] args) {
		int i = 1;
		Scanner keyboard = new Scanner(System.in);
		int max = Integer.parseInt(keyboard.next());
			do{
			String input = keyboard.next();
			flipNumbers = 0;
			System.out.println("Case #" + i + ": " + allSmiley(input));
			i++;
			}while(i <= max);
	}

	public static int allSmiley(String s){
		smiley = 0;
		blank = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '+'){
				smiley++;
			}
			else if(s.charAt(i) == '-'){
				blank++;
			}
		}
		if(smiley != s.length()){
			allSmiley(flip(s));
		}
		return flipNumbers;
	}
	
	public static String flip(String p){
		String flipped = p;
		String switchered = p.substring(0, 1);
		String indexToFlip = "";
		int current = 0;
		while( current < p.length()){
			if(p.length() == 1 && p.charAt(0) == '-'){
				current = 1;
				flipNumbers++;
				flipped = "+";
			}
			else if(p.length() > 0 && p.charAt(0) != p.charAt(1)){
				flipNumbers++;
				current = 1;
				switchered = switcher(p.substring(0, 1));
				flipped = switchered + p.substring(1);
			 }
			else if(switchered.charAt(0) == p.charAt(current)){
					indexToFlip = p.substring(0, current);
					current++;
			}
			else if(switchered.charAt(0) != flipped.charAt(current) || flipped.length() == switchered.length()){
					flipNumbers++;
					switchered = switcher(indexToFlip);
					flipped = switchered + p.substring(current - 1);
				}
		}
	if(indexToFlip == current-1){
		flipNumbers++;
		switchered = switcher(flipped.substring(0, current));
		flipped = switchered + p.substring(indexToFlip);
	}
		
			
//			else if(p.length() > 0 && p.charAt(0) != p.charAt(1)){
//				if(p.charAt(0) != p.charAt(1)){
//					flipNumbers++;
//					flipped += switcher(p.substring(0, 1)) + p.substring(1, p.length());
//				}	
//				else{
//				while(j < p.length() - 1){
//					if(p.charAt(j) == p.charAt(j+1)){
//					indexToFlip++;
//					}
//					j++;
//				}
//			}
//				flipNumbers++;
//				flipped += switcher(p.substring(0, indexToFlip)) + p.substring(indexToFlip);
//				flipNumbers++;
//				flipped = switcher(flipped);
//			}
//		else if(firstBlank > p.length()/2 || blank > smiley){
//			flipNumbers++;
//			flipped = switcher(p);
//		}
//		
//		else if(firstBlank > p.length()/2 || blank > smiley){
//			flipNumbers++;
//			flipped = switcher(p);
//		}
	
			
		return flipped;
	}
	
	public static String switcher(String s){
		String negated = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '-')
			{
				negated += "+";
			}
			else{
				negated += "-";
			}
		}
		return reverser(negated);
	}
	
	public static String reverser(String s){
		String reversed = "";
		for(int p = s.length() - 1; p >= 0; p--){
			reversed += s.substring(p, p + 1);
		}
		return reversed;
	}
}
