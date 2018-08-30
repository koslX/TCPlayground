/**
 * Created by Karol on 30/08/2018.
 *
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 *
 */

import java.util.Arrays;

public class PickingNumbers {
	
    // Complete the pickingNumbers function below.
    static int pickingNumbers(int[] a) {
    	
    	Arrays.sort(a);
    	
    	int start = 0;
    	int mid = 0;
    	int maxL = 1;
    	
    	for(int i = 1; i < a.length; i++)
    	{


    		if(a[i] > a[i-1])
    		{
    			if(a[i] > a[i-1]+1)
    				start = i;

    			else
    				start = mid;
    			
				mid = i;
    		}

			if(i-start+1 > maxL)
				maxL = i-start + 1;
    		
    	}
    	
    	return maxL;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
