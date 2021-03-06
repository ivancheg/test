package core;

import java.util.Random;

public class GenerateRandom {

	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static Integer randInt(int min, int max) {
		Random rand = new Random();
		Integer randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	/**
	 * Returns random element from string array
	 * @param arrData
	 * @return
	 */
	public static String randFromArray(String[] arrData){
		int rand = randInt(0,arrData.length-1);
		String result = arrData[rand];
		return result;
	}
	
	/**
	 * Returns random boolean true or false 
	 * @return
	 */
	public static Boolean randBoolean(){
		Boolean[] arrData = {true, false};
		int rand = randInt(0,arrData.length-1);
		Boolean result = arrData[rand];
		return result;
	}
	
}
