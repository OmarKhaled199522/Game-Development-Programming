package eg.edu.alexu.csd.ds.hangman.csd44OmarKhaled;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class HangmanDummyEngine implements IHangman{
	
	String help [] = new String [22];
	String select ="";
	String match = "";
	char [] comp = new char [20];
	int wrong = 0;
	

	@Override
	public void setDictionary(String[] words) {
		
		help = words;
	}

	@Override
	public String selectRandomSecretWord() {
		
		while(true){
			int rand = (int)(Math.random() * help.length);
			select = help[rand];
			if (!select.isEmpty()) break;
		}
		for(int i = 0; i < select.length(); i++){
			comp[i] = select.charAt(i);
			match += "-";
		}
		comp[select.length()] = '\0';
		return select;
	}

	@Override
	public String guess(Character c) {
		
		int found = 0,  correct = 0 ;
		if(c == '\n'){
			System.out.println("Invalid input!!!!!");
			return null;
		}
		else {
			
			for(int i = 0; comp[i] != '\0' ;i++){
				if (c == comp[i]){
					
					found = 1;
					correct++;
					
					StringBuilder sb = new StringBuilder(match);
					sb.setCharAt(i,c);
					match = sb.toString();  
					
				}
			}
			
			if(found == 0){
				wrong++;
				System.out.println("Wrong guess!!!!!");
				setMaxWrongGuesses(5);
				if (wrong == -1) return null;
				
			} else   System.out.println("Good guess !!!!!"); 	
			
		}
		
		return match;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		
		if(wrong == max) wrong = -1;
		
	}
}
