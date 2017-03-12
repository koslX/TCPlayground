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
        //Cut cut = new Cut();
        //ABA abba = new ABBA();
        SlimeXSlimesCity sxsc = new SlimeXSlimesCity();
        System.out.println(sxsc.merge(new int []


                {1000000000, 999999999, 999999998, 999999997}

        ));
        /*LargestSubsequence ls = new LargestSubsequence();
        System.out.println(ls.getLargest("test"));
        System.out.println(ls.getLargest("aquickbrownfoxjumpsoverthelazydog"));
        MovingCandies mCan = new MovingCandies();
        System.out.println(mCan.minMoved(new String[]
                {
                        "##",
                        "#."
                }));
        System.out.println(mCan.minMoved(new String[]
                {
                        "#...###",
                        "#...#.#",
                        "##..#.#",
                        ".#....#"
                }));
        System.out.println(mCan.minMoved(new String[]
                {
                        "#...###",
                        "#...#.#",
                        "##..###",
                        ".#....#"
                }));
        System.out.println(mCan.minMoved(new String[]
                {
                        ".#..",
                        "##..",
                        "..#.",
                        "..#.",
                        "..##",
                        "..##"
                }));
        System.out.println(mCan.minMoved(new String[]
                {
                        ".....",
                        ".###.",
                        "####.",
                        "....."
                }));
        System.out.println(mCan.minMoved(new String[]
                {
                        ".#...#.###.#",
                        "#.#.##......",
                        ".#.#......#.",
                        "..#.......#.",
                        "##.........."
                }));
        System.out.println(mCan.minMoved(new String[]
                {
                        "###.#########..#####",
                        ".#######.###########"
                }));
        System.out.println(mCan.minMoved(new String[]
                {
                        "..",
                        ".."
                }));

/*        OthersXor oXor = new OthersXor();

        System.out.println(oXor.minSum(new int []{0,0,1}));
        System.out.println(oXor.minSum(new int []{0,0,1,1}));
        System.out.println(oXor.minSum(new int []{70,100}));
        System.out.println(oXor.minSum(new int []{-1,0,-1,100,36}));
        System.out.println(oXor.minSum(new int []{0,536870912,0,536870912,0,536870912,0,536870912,0,536870912,
                0,536870912,0,536870912,0,536870912,0,536870912,0,536870912,
                1073741823,1073741823,1073741823,123456789,987654321,804289383}));
        System.out.println(oXor.minSum(new int []{1287325,424244444,92759185,812358213,1000000000,825833522,749092703}));
        System.out.println(oXor.minSum(new int []{-1, -1}));*/
        //YetAnotherIncredibleMachine yaim = new YetAnotherIncredibleMachine();
        //System.out.println(yaim.countWays(new int []{1},new int [] {2},new int [] {0,3}));
        //System.out.println(yaim.countWays(new int []{8},new int [] {2},new int [] {4, 9}));
        //System.out.println(yaim.countWays(new int []{1,4},new int [] {3,3},new int [] {2,7}));
        //System.out.println(yaim.countWays(new int []{4,4,4},new int [] {10,9,8},new int [] {1,100}));
        //System.out.println(yaim.countWays(new int []{0},new int [] {1},new int [] {0}));
        //System.out.println(yaim.countWays(new int []{100, -4215, 251},new int [] {400, 10000, 2121},new int [] {5000, 2270, 8512, 6122}));
        //System.out.println(abba.canObtain("A", "BB"));
        //System.out.println( cut.getMaximum(new int [] {30, 50, 30, 50}, 350));
        //Substitute subs = new Substitute();
        //AlphabetOrderDiv1 alfa = new AlphabetOrderDiv1();
        //System.out.println(alfa.isOrdered(new String[] {"topcoder"}));
        //System.out.println(alfa.isOrdered(new String[] {"algorithm", "contest"}));
        //System.out.println(subs.getValue("TRADINGFEW", "LGXWEV"));
        //System.out.println("Hello, World");
    }
}
