/**
 * Created by Karol on 05/02/2017.
 */

import java.util.Dictionary;
import java.util.Hashtable;

public class Substitute {

    int getValue(String key, String code){
        int val = 1;
        Dictionary<Character, Integer> vals = new Hashtable<>();
        for(char c : key.toCharArray()) {
            vals.put(c, val);
            val += 1;
            val = val % 10;
        }

        int result = 0;

        for(char c : code.toCharArray()){
            Integer corrVal = vals.get( c );
            if(corrVal != null) {
                result = corrVal + result * 10;
            }
        }

        return result;
    }
}
