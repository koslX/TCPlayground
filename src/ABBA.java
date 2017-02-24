/**
 * Created by Karol on 20/02/2017.
 *
 * solution for https://community.topcoder.com/stat?c=problem_statement&pm=13918
 *
 */
public class ABBA {

    private boolean checkIdentity(int left, int right, int direction, char [] initial, char [] target) {
        if(direction == -1)
            for(char letter : initial) {
                if (letter != target[right])
                    return false;
                right--;
            }
        else
            for(char letter : initial) {
                if (letter != target[left])
                    return false;
                left++;
            }

        return true;

    }

    public String canObtain(String initial, String target) {

        char [] initialArray = initial.toCharArray();
        char [] targetArray = target.toCharArray();
        int left = 0;
        int right = target.length()-2;
        int distance = right - left + 1;
        int direction = (targetArray[targetArray.length-1] == 'B')?-1:1;

        while( distance > initialArray.length ) {
            if(direction==1) {
                direction = (targetArray[right] == 'B')?-1:1;
                right--;
            }
            else {
                direction = (targetArray[left] == 'B')?1:-1;
                left++;
            }
            distance = right - left + 1;
        }

        if(distance == initialArray.length){
            if(checkIdentity(left, right, direction, initialArray,targetArray))
                return "Possible";
        }


        return "Impossible";
    }

}
