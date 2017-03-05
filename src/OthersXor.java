/**
 * Created by Karol on 25/02/2017.
 *
 * Solution for https://community.topcoder.com/stat?c=problem_statement&pm=14396
 *
 */
public class OthersXor {
    public long minSum(int[] x) {

        long result = 0;

        int [] counters = new int[30]; // ilosc jedynek na i'tej pozycji
        int [] masks = new int[30]; // maska bitowa n'tego bitu na n'tej pozycji
        int neg = 0; // ilosc zer

        int val = 1;
        for(int i = 0; i < 30; i++) {
            masks[i] = val;
            val = val << 1;
        }

        for( int i = 0; i < x.length; i++) {
            if(x[i] != -1) {
                        for( int j = 0; j < 30; j++)
                            counters[j] += ((x[i]&masks[j])>0?1:0);
            }
            else
                neg++;
        }

        for(int i = 0; i < 30; i++) {
            int lRes = -1;
            int zeroes = x.length - counters[i] - neg;
            int ones = counters[i];
            if((zeroes & 1) == 0) {
                if( neg > 0 )
                    lRes = zeroes+1;
            }
            else
                lRes = zeroes;

            if(((ones & 1) == 0) && ((ones < lRes)||(lRes==-1)))
                lRes = ones;
            else
                if((neg>0)&&((ones+1 < lRes)||(lRes==-1)))
                    lRes = ones + 1;

            if( lRes == -1 )
                return -1;
            result = Math.addExact(result, Math.multiplyExact((long)masks[i], (long)lRes));
        }


        return result;
    }
}
