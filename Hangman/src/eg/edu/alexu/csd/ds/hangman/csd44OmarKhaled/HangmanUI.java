package eg.edu.alexu.csd.ds.hangman.csd44OmarKhaled;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class HangmanUI {
	
	public static void main(String[] args) {
		
		IHangman hangman = new HangmanDummyEngine();
		Scanner input = new Scanner(System.in);
		String [] arr = new String [22];
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("testing.txt"));
		} catch (FileNotFoundException e) {
		
			System.out.println("File Not Found!!!!!");
		}

		try {
			for(int i = 0; (arr[i] = br.readLine() ) != null; i++);
			
		} catch (IOException e) {
			
			
		}
		hangman.setDictionary(arr);
		String secret = hangman.selectRandomSecretWord();
		hangman.setMaxWrongGuesses(5);
		System.out.println("Welcome to Hangman Game\nNote:Maximum Wrong answers is 5\n"
				+ "Enter only alphabatics(small or capital)");
		for(int i = 0; i < secret.length() ; i++){
			System.out.print("- ");
		}
		System.out.println();
		
		do{
			char guess = input.next().toUpperCase().charAt(0);
			String result = hangman.guess(guess);
			
			if(result==null){
				System.out.println("Fail! correct answer = '" + secret + "'");
				return;
			}
			
			for(int i = 0; i < result.length(); i++)
				System.out.print(result.charAt(i)+" ");
			System.out.println("");
			if(!result.contains("-")){
				System.out.println("Well Done!");
				return;
			}
			
			
		}while(true);
	}
}