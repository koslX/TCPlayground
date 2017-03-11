import java.util.HashMap;

/**
 * Created by Karol on 11/03/2017.
 *
 * Solution for https://community.topcoder.com/stat?c=problem_statement&pm=11327&rd=14428
 *
 */
public class ColorfulRabbits {

    public int getMinimum(int[] replies) {
        int result = 0;
        HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
        for(int r:replies) {
            if(counters.containsKey(r)) {
                int val = counters.get(r);
                if(val == 0) {
                    result += (r+1);
                    counters.put(r, r);
                } else
                    counters.put(r, val-1);
            } else {
                counters.put(r, r);
                result += (r+1);
            }
        }
        return result;
    }

}
