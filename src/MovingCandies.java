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
        public int stepsRemaining;

        /*public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }*/
        public Coordinates(int x, int y,int stepsRemaining) {
            this.x = x;
            this.y = y;
            this.stepsRemaining = stepsRemaining;

        }
    }

    Coordinates [] getNeighbours(Coordinates pos, int boardXsize, int boardYsize, int stepsRemaining) {
        ArrayList<Coordinates> result = new ArrayList<>();
        if(pos.x > 0)
            result.add(new Coordinates(pos.x-1, pos.y, stepsRemaining));
        if(pos.y > 0)
            result.add(new Coordinates(pos.x, pos.y-1, stepsRemaining));
        if(pos.x < boardXsize-1)
            result.add(new Coordinates(pos.x+1,pos.y, stepsRemaining));
        if(pos.y< boardYsize-1)
            result.add(new Coordinates(pos.x,pos.y+1, stepsRemaining));
        Coordinates [] toRet = new Coordinates[result.size()];

        return  result.toArray(toRet);

    }


    public int minMoved(String[] t) {
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

        coordQueue.add(new Coordinates(1,0, totalCookiesCount-1));
        coordQueue.add(new Coordinates(0,1, totalCookiesCount-1));

        while(coordQueue.size() > 0) {
            Coordinates curr = coordQueue.remove();;
            if(curr.stepsRemaining > 0) {

                Coordinates[] neighbours = getNeighbours(curr, alreadyCalculated.length, alreadyCalculated[0].length, curr.stepsRemaining - 1);
                int min = Integer.MAX_VALUE;
                for (Coordinates c : neighbours)
                    min = (min - +((t[curr.x].charAt(curr.y) == '#') ? 0 : 1) > alreadyCalculated[c.x][c.y]) ? alreadyCalculated[c.x][c.y] + ((t[curr.x].charAt(curr.y) == '#') ? 0 : 1) : min;

                alreadyCalculated[curr.x][curr.y] = min;

                for (Coordinates c : neighbours)
                    if (alreadyCalculated[c.x][c.y] > alreadyCalculated[curr.x][curr.y] + ((t[c.x].charAt(c.y) == '#') ? 0 : 1))
                        coordQueue.add(c);
            }

        }


        return ((alreadyCalculated[t.length-1][t[0].length()-1] < Integer.MAX_VALUE))?alreadyCalculated[t.length-1][t[0].length()-1]:-1;
    }


}


