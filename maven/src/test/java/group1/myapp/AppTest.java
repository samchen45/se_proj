package group1.myapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

	private static App testladder = new App();
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("false");
	}

	@Test
	void test() {
		Set<String> dict = new HashSet<String>();
        dict.add("hit");
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        dict.add("doc");
        assertEquals(4, testladder.wordLadder("hit","doc",dict));
	}

}
