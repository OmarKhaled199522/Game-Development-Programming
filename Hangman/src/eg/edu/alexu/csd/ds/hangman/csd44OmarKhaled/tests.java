package eg.edu.alexu.csd.ds.hangman.csd44OmarKhaled;

import static org.junit.Assert.*;

import org.junit.Test;

public class tests {

	HangmanDummyEngine test = new HangmanDummyEngine(); 
	
	@Test
	public void test01() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		assertEquals( "MOHAMED" ,test.selectRandomSecretWord());
	}

	@Test
	public void test02() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(5);
		assertEquals( "-------" ,test.guess(null));
	}
	
	@Test
	public void test03() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(1);
		assertEquals( "-------" ,test.guess(null));
		assertEquals(  "-------" ,test.guess('X'));
		assertEquals( null ,test.guess('X'));
	}
	
	@Test
	public void test04() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(9);
		assertEquals( "-------" ,test.guess(null));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals( "-------" ,test.guess('B'));
		assertEquals(  null ,test.guess('B'));
	}
	
	@Test
	public void test05() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(5);
		assertEquals( "-------" ,test.guess(null));
		assertEquals( "M---M--" ,test.guess('M'));
		assertEquals( "M---M--" ,test.guess('M'));
		assertEquals( "MO--M--" ,test.guess('O'));
		assertEquals( "MO--M-D" ,test.guess('D'));
		assertEquals( "MO--M-D" ,test.guess('L'));
		assertEquals( "MO--M-D" ,test.guess('W'));
		assertEquals( "MO--MED" ,test.guess('E'));	
		assertEquals( "MO--MED" ,test.guess('P'));	
		assertEquals( "MO--MED" ,test.guess('U'));
		assertEquals( "MO--MED" ,test.guess('B'));
		assertEquals( null ,test.guess('T'));	
	}
	
	@Test
	public void test06() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(5);
		assertEquals( "-------" ,test.guess(null));
		assertEquals( "M---M--" ,test.guess('M'));
		assertEquals( "M---M--" ,test.guess('M'));
		assertEquals( "MO--M--" ,test.guess('O'));
		assertEquals( "MO--M-D" ,test.guess('D'));
		assertEquals( "MO--M-D" ,test.guess('L'));
		assertEquals( "MO--M-D" ,test.guess('W'));
		assertEquals( "MO--MED" ,test.guess('E'));	
		assertEquals( "MO--MED" ,test.guess('P'));	
		assertEquals( "MO--MED" ,test.guess('U'));	
		assertEquals( "MOH-MED" ,test.guess('H'));
		assertEquals( "MOHAMED" ,test.guess('A'));
	}
	
	@Test
	public void test07() {
		String word[] ={"NNNNNNNN"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(5);
		assertEquals( "--------" ,test.guess(null));
		assertEquals( "NNNNNNNN" ,test.guess('N'));	
	}
	
	@Test
	public void test08() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(30);
		assertEquals( "-------" ,test.guess('\n'));
		assertEquals( "-------" ,test.guess('\t'));
		assertEquals( "-------" ,test.guess('1'));
		assertEquals( "-------" ,test.guess('!'));
		assertEquals( "-------" ,test.guess('@'));
		assertEquals( "-------" ,test.guess('#'));
		assertEquals( "-------" ,test.guess('$'));
		assertEquals( "-------" ,test.guess('^'));
		assertEquals( "-------" ,test.guess('&'));
		assertEquals( "-------" ,test.guess('*'));
		assertEquals( "-------" ,test.guess('&'));
		assertEquals( "-------" ,test.guess('('));
		assertEquals( "-------" ,test.guess('_'));
		assertEquals( "-------" ,test.guess('-'));
		assertEquals( "-------" ,test.guess('+'));
		assertEquals( "-------" ,test.guess('='));
		assertEquals( "-------" ,test.guess(','));
		assertEquals( "-------" ,test.guess(';'));
		assertEquals( "-------" ,test.guess('"'));
		assertEquals( "-------" ,test.guess('/'));
		assertEquals( "-------" ,test.guess('>'));
		assertEquals( "-------" ,test.guess('<'));
		assertEquals( "-------" ,test.guess('í'));
		assertEquals( "-------" ,test.guess('ä'));
		assertEquals( "-------" ,test.guess('Î'));
		assertEquals( "-------" ,test.guess('ã'));
		assertEquals( "-------" ,test.guess('m'));
		assertEquals( "-------" ,test.guess('e'));
	}
	
	@Test
	public void test09() {
		String word[] ={"MOHAMED"} ;
		test.setDictionary(word);
		test.selectRandomSecretWord();
		test.setMaxWrongGuesses(0);
		assertEquals( "M---M--" ,test.guess('M'));
		assertEquals( "M---M--" ,test.guess('M'));
		assertEquals( "MO--M--" ,test.guess('O'));
		assertEquals( "MO--M-D" ,test.guess('D'));
		assertEquals( "MO--MED" ,test.guess('E'));	
		assertEquals( "MOH-MED" ,test.guess('H'));
		assertEquals( "MOHAMED" ,test.guess('A'));
	}
	
}
