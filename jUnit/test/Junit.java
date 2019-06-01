package test;
/**
 * 
 * @author muzhouchen
 * last modified: May 30, 2019
 * Overview: this program is adding coins from combination from large to small to achieve the total amount;
 * This program is used to throw exceptions when meet exception from user;
 * the class Junit include all exceptions and feedback to user;
 *
 */
public class Junit {
	//we create a coin used array with a size 8 just in case; initialize l in order to store the location; 
	public static Integer[] combinations(int[] coinCombination, int totalAmount) {
		Integer[] coinUsed = new Integer[8];
		int l = 0;
		//the coinCombination has nothing; we throw a illegal argument exception; 
		if(coinCombination.length == 0) {
			throw new IllegalArgumentException("Cannot have a blank coin combination");
		}
		//if the coinCombination contains a 0, the program will stuck in an infinity loop; 
		//so that we throw a exception that notice user cannot put 0 in it; 
		for(int i = 0 ; i < coinCombination.length; i++) {
			if(coinCombination[i] == 0) {
				throw new IllegalArgumentException("Please do not include 0");
			}
		}
		//for example, if we have all even coins in coinCombination, we cannot get a odd number of total amount; 
		//so we state cannot get a even coin amount; 
		while(totalAmount!=0) {
			for(int i = coinCombination.length -1; i < coinCombination.length; i--) {
				if(coinCombination[i] <= totalAmount) {
					totalAmount = totalAmount - coinCombination[i];
					coinUsed[l] = coinCombination[i];
					l ++;
					break;
				}
				else if (coinCombination[0] > totalAmount){
					throw new IllegalArgumentException("Cannot get a even coin amount");
				}
				else {
					continue; 
				}
			}
			if(l == 8) {
				break;
			}
		}
		return coinUsed;
	}
}
