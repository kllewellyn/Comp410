import java.util.Scanner;

public class Problem1 {

	static String input;
	static int totalNums = 0;
	static int count;
	static String[] numbers;
	static String originalInput;
	public static void main(String[] args) {
	int i = 1;
	Scanner keyboard = new Scanner(System.in);
	int max = Integer.parseInt(keyboard.next());
	numbers = new String[10];
		do{
		String input = keyboard.next();
		originalInput = input;
		count = 2;
		System.out.println("Case #" + i + ": " + countNumbers(input));
		i++;
		}while(i <= max);
	}
	
	
	public static String countNumbers(String i){
	if((count >= 900 || Integer.parseInt(i) <= 0) && !isFull(numbers)){
		numbers = new String[10];
		return "INSOMNIA";
	}
		for(int k = 0; k < i.length(); k++){
			char temp = i.charAt(k);
			if(temp == '0'){
				numbers[0] = "0";
			}
			else if(temp == '1'){
				numbers[1] = "1";
			}
			else if(temp == '2'){
				numbers[2] = "2";
			}
			else if(temp == '3'){
				numbers[3] = "3";
			}
			else if(temp == '4'){
				numbers[4] = "4";
			}
			else if(temp == '5'){
				numbers[5] = "5";
			}
			else if(temp == '6'){
				numbers[6] = "6";
			}
			else if(temp == '7'){
				numbers[7] = "7";
			}
			else if(temp == '8'){
				numbers[8] = "8";
			}
			else if(temp == '9'){
				numbers[9] = "9";
			}
		}
		if(isFull(numbers)){
			numbers = new String[10];
			return i;
		}
		else{
			Integer doubleTime = ((Integer)count*Integer.parseInt(originalInput));
			String nextUp = doubleTime.toString();
			count++;
			return(countNumbers(nextUp));
		}
		
	}
	
	public static boolean isFull(String[] s){
		int truth = 0;
		for(int p = 0; p < 10; p++){
			if(s[p] != null){
				truth++;
			}
		}
		if(truth == 10){
			return true;
		}
		return false;
	}
	
	

}
