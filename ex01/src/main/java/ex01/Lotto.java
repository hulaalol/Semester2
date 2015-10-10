package ex01;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	
	public static void main(String[] args) {
		
		int[] input = getUserInput();
		int[] win = generiereLottoZahlen();
		
		System.out.println(compareNumbers(input,win));
	}
	
	
	
	
	
	static String compareNumbers(int[] input, int[] win) {
		
		
		Arrays.sort(input);
		Arrays.sort(win);
		
		int richtige = 0;
		
		for (int i=0; i<6; i++){
			
			if (input[i]==win[i]){
				
				richtige++;
			}
			
		}
		
		return "Du hast "+richtige+" richtige Gewinnzahlen!";
	}
	
	
	
	
	static int[] getUserInput(){
		
		System.out.println("Geben sie ihre Gewinnzahlen, getrennt mit Leerzeichen ein:");
		
		Scanner input = new Scanner(System.in);
		
		String userInput = input.nextLine();
		
		String[] userNumbers = userInput.split(" ");
		
		int[] numbers = new int[6];
		
		for (int i=0; i<userNumbers.length ;i++){
			
			numbers[i] = Integer.parseInt(userNumbers[i]);
		}
		
		return numbers;
		

	}
	
	
	
	
	
	static int[] generiereLottoZahlen(){

		int[] statistics = new int[50];
		Arrays.fill(statistics, 0);
		
		int[] numbers = new int[6];
		
		
			
			for (int i=0; i<6; i++){
				
				int random = (int) (Math.random()*49)+1;
				numbers[i] = random;
				
				
				for (int p =0; p<i ; p++){
						
						if (numbers[p]==random){
							i--;
						}
						
					}
	
		}
		
		return numbers;

	}
	

}
