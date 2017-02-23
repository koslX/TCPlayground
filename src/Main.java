/**
 * Created by Karol on 05/02/2017.
 */
import java.util.ArrayList;
import java.util.Arrays;


public class Main {


    private static Integer head( ArrayList<Integer> list) {
        if(list.size() == 0)
            return null;
        else
            return list.get(0);
    }

    private static ArrayList<Integer> tail(ArrayList<Integer> list) {
        if(list.size() < 1)
            return null;
        else
            return new ArrayList<Integer>(list.subList(1, list.size()));
    }

    private static boolean checkIfContains(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        if(arr1.size() != arr2.size())
            return false;

        for( int i = 0; i < arr2.size(); i++) {
            if( arr1.equals(arr2) )
                return true;
            else {
                ArrayList<Integer> arr = tail(arr2);
                Integer headVal = head(arr2);
                arr.add(headVal);
                arr2 = arr;
            }
                //arr2 = tail(arr2).add(head(arr2));
        }
        return false;
    }

    private static ArrayList<Integer> generateList( String bullet )
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(char c : bullet.toCharArray())
            if( c == '|' )
                numbers.add(1);
            else
                numbers.add(-1);

        ArrayList <Integer>result = new ArrayList<>();
        Integer val = 0;
        for( int i = 0; i < numbers.size(); i++) {
            if(i == 0)
                val += numbers.get(i);
            else
                if( !numbers.get(i-1).equals( numbers.get(i) )) {
                    result.add(val);
                    val = numbers.get(i);
                }
                else
                    val += numbers.get(i);

            if(i == numbers.size()-1 && numbers.get(0).equals(numbers.get(i))) {
                if(result.size()>0)
                    result.set(0, result.get(0) + val);
                else
                    result.add(val);
            }

            if(i==numbers.size()-1 && !numbers.get(0).equals(numbers.get(i))) {
                result.add(val);
            }


        }

        return result;
    }

    public static int match(String[] guns, String bullet)
    {
        ArrayList<Integer> bulletArray = generateList(bullet);
        for(int i = 0; i < guns.length; i++) {
            String c = guns[i];
            if (checkIfContains(generateList(c), bulletArray))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window. topcoder
        /*String[] guns = new String[] {};  eabcatyu topcoder
        System.out.println(match( guns, "||| ||| "));*/
        Cut cut = new Cut();

        System.out.println( cut.getMaximum(new int [] {30, 50, 30, 50}, 350));
        //Substitute subs = new Substitute();
        //AlphabetOrderDiv1 alfa = new AlphabetOrderDiv1();
        //System.out.println(alfa.isOrdered(new String[] {"topcoder"}));
        //System.out.println(alfa.isOrdered(new String[] {"algorithm", "contest"}));
        //System.out.println(subs.getValue("TRADINGFEW", "LGXWEV"));
        //System.out.println("Hello, World");
    }
}
