import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Karol on 08/03/2017
 *
 * Solution for https://community.topcoder.com/stat?c=problem_statement&pm=14505
 *
 * doesn't work yet (it's not really replacing tiles so they can be used twice
 * .
 */
public class MovingCandies {

    private static class Coordinates {
        public int x;
        public int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Coordinates [] getNeighbours(Coordinates pos, int boardXsize, int boardYsize) {
        ArrayList<Coordinates> result = new ArrayList<>();
        if(pos.x > 0)
            result.add(new Coordinates(pos.x-1, pos.y));
        if(pos.y > 0)
            result.add(new Coordinates(pos.x, pos.y-1));
        if(pos.x < boardXsize-1)
            result.add(new Coordinates(pos.x+1,pos.y));
        if(pos.y< boardYsize-1)
            result.add(new Coordinates(pos.x,pos.y+1));
        Coordinates [] toRet = new Coordinates[result.size()];

        return  result.toArray(toRet);

    }


    int minMoved(String[] t) {
        Queue<Coordinates> coordQueue = new LinkedList<Coordinates>();
        int totalCookiesCount = 0;

        int [][] alreadyCalculated = new int [t.length][t[0].length()];
        for( int i = 0; i < t.length; i++)
            for( int j = 0; j <  t[0].length(); j++) {
                alreadyCalculated[i][j] = Integer.MAX_VALUE;
                if(t[i].charAt(j) == '#')
                    totalCookiesCount++;
            }

        alreadyCalculated[0][0] = (t[0].charAt(0) == '#')?0:1;

        coordQueue.add(new Coordinates(1,0));
        coordQueue.add(new Coordinates(0,1));

        while(coordQueue.size() > 0) {
            Coordinates curr = coordQueue.remove();
            Coordinates[] neighbours = getNeighbours(curr,alreadyCalculated.length,alreadyCalculated[0].length);
            int min = Integer.MAX_VALUE;
            for(Coordinates c : neighbours)
                min = (min - + ((t[curr.x].charAt(curr.y) == '#') ? 0 : 1) > alreadyCalculated[c.x][c.y] )?alreadyCalculated[c.x][c.y] + ((t[curr.x].charAt(curr.y) == '#') ? 0 : 1):min;

            alreadyCalculated[curr.x][curr.y] = min;

            for(Coordinates c : neighbours)
                if (alreadyCalculated[c.x][c.y] > alreadyCalculated[curr.x][curr.y] + ((t[c.x].charAt(c.y) == '#') ? 0 : 1))
                    coordQueue.add(new Coordinates(c.x, c.y));

        }


        //TODO broken condition
        return ((alreadyCalculated[t.length-1][t[0].length()-1] <= totalCookiesCount))?alreadyCalculated[t.length-1][t[0].length()-1]:-1;
    }


}

/*    int getReachCost(int x, int y, int[][] alreadyCalculated, String[] t) {

        if(x<0 || x>= alreadyCalculated.length || y < 0 || y >= alreadyCalculated[0].length || alreadyCalculated[x][y] == Integer.MAX_VALUE-1)
            return Integer.MAX_VALUE;


        if(alreadyCalculated[x][y] < Integer.MAX_VALUE-1)
            return alreadyCalculated[x][y];

        alreadyCalculated[x][y] = Integer.MAX_VALUE-1;

        int res = Math.min(getReachCost(x+1,y, alreadyCalculated, t), Math.min(getReachCost(x,y-1, alreadyCalculated, t),
                Math.min(getReachCost(x-1, y, alreadyCalculated, t), getReachCost(x, y+1, alreadyCalculated, t)))) +
                ((t[x].charAt(y) == '#')?0:1);

        alreadyCalculated[x][y] = res;

        return res;

    }

    int minMoved(String[] t) {
        int totalCookiesCount = 0;
        int [][] alreadyCalculated = new int [t.length][t[0].length()];
        for( int i = 0; i < t.length; i++)
            for( int j = 0; j <  t[0].length(); j++) {
                alreadyCalculated[i][j] = Integer.MAX_VALUE;
                if(t[i].charAt(j) == '#')
                    totalCookiesCount ++;
            }

        alreadyCalculated[0][0] = (t[0].charAt(0) == '#')?0:1;

        int reachCost = getReachCost(t.length -1, t[0].length() -1, alreadyCalculated, t);

        if(reachCost <= totalCookiesCount)
            return reachCost;
        else
            return -1;
    }
*/

