/**
 * Created by Karol on 28/08/2018.
 *
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 *
 */


public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int[] ar) {

    	int count=0, curMax=-1;
    	
    	for(int i = 0; i < ar.length; i++)
    	{
    		if(ar[i] > curMax)
    		{
    			count = 1;
    			curMax = ar[i];
    		}
    		else
    		if(ar[i] == curMax)
    			count++;
    	}
    	
    	
    	return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
