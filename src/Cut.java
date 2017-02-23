/**
 * Created by Karol on 23/02/2017.
 *
 * solution for https://community.topcoder.com/stat?c=problem_statement&pm=11564
 *
 */


import java.util.Arrays;
import java.util.Comparator;

public class Cut {

    public int getMaximum( int[] eelLengths, int maxCuts) {

        Integer[] sorted = new Integer[ eelLengths.length ];

        int pos = 0;
        for(int len : eelLengths)
            sorted[pos++] = new Integer(len);
        Arrays.sort(sorted, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                int mod10_01 = ((o1 % 10)>0) ? 1 : 0;
                int mod10_02 = ((o2 % 10)>0) ? 1 : 0;
                if( mod10_01 == mod10_02)
                    return o1.compareTo(o2);
                if(mod10_01 == 0)
                    return -1;
                else
                    return 1;

            }
        } );

        int cutsRemaining = maxCuts;
        int eelPos = 0;
        int eelNum = 0;
        while(cutsRemaining > 0 && eelPos < sorted.length) {
            int remainder = sorted[eelPos] % 10;
            int cutsReq;
            if(remainder == 0)
                cutsReq = sorted[eelPos]/10 - 1;
            else
                cutsReq = sorted[eelPos]/10;

            if(cutsRemaining >= cutsReq) {
                eelNum += cutsReq;
                if( remainder == 0)
                    eelNum++;
                cutsRemaining -= cutsReq;
            }
            else {
                eelNum += cutsRemaining;
                cutsRemaining = 0;
            }
            eelPos++;
        }

        return eelNum;
    }

}
