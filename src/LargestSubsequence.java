import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karol on 10/03/2017.
 *
 * solution for https://community.topcoder.com/stat?c=problem_statement&pm=11471&rd=14543
 *
 */
public class LargestSubsequence {

    String getLargest(String s) {
        String result = "";
        List<Character> candidate = new ArrayList<Character>();

        for(char c : s.toCharArray()) {
            int pos = 0;
            while(pos < candidate.size() && ((int)candidate.get(pos) >= (int) c))
                pos++;
            candidate = candidate.subList(0, pos);
            candidate.add(c);

        }



        return candidate.stream().map(e->e.toString()).reduce((acc,e) -> acc + e).get();
    }

}
