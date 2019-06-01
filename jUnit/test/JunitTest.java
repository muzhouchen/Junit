package test;
/**
 * 
 * @author muzhouchen
 * last modified: May 30, 2019
 * Overview: this class is used to test 4 cases; 
 * you need to download Junit package then we can import Junit from IDE; 
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class JunitTest {
//case 1: when coinCombination is null, it is an exception; 
	@Test
	void testOne() {
		int[] coinCombination = {};
		Exception exc = assertThrows(IllegalArgumentException.class, () -> {Junit.combinations(coinCombination, 42); });
		assertEquals("Cannot have a blank coin combination", exc.getMessage());
	}
//case 2: in this case, we can successfully get the right answer when coinCombination has 1, 5, 10, 25
//we will pick a 25, 10, 5 , then add 1 till we get the total amount which is 42; 
	@Test
	void testTwo() {
		int[] coinCombination = {1,5,10,25};
		Integer[] answer = {25,10,5,1,1,null,null,null};
		assertTrue(Arrays.equals(answer,Junit.combinations(coinCombination, 42)));
	}
//case 3: when we have all even numbers of coin in coinCombination, we can't get a odd final total amount like 43; 
	@Test
	void testThree() {
		int[] coinCombination = {2,4,6,8};
		Exception exc = assertThrows(IllegalArgumentException.class, () -> {Junit.combinations(coinCombination, 43); });
		assertEquals("Cannot get a even coin amount", exc.getMessage());
	}
//case 4: when we have a 0 in the coinCombination, the program will stuck in an infinity loop which is keep adding 0 ;
	@Test
	void testFour() {
		int[] coinCombination = {0,1,5,10,25};
		Exception exc = assertThrows(IllegalArgumentException.class, () -> {Junit.combinations(coinCombination, 42); });
		assertEquals("Please do not include 0", exc.getMessage());
	}

}
