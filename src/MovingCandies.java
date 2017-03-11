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

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Coordinates(int x, int y,int stepsRemaining) {
            this.x = x;
            this.y = y;
            this.stepsRemaining = stepsRemaining;

        }
    }

    ArrayList<Coordinates> getNeighbours(Coordinates pos, int boardXsize, int boardYsize, int stepsRemaining) {
        ArrayList<Coordinates> moves = new ArrayList<>();
        ArrayList<Coordinates> result = new ArrayList<>();
        moves.add(new Coordinates(1,0));
        moves.add(new Coordinates(0,1));
        moves.add(new Coordinates(0,-1));
        moves.add(new Coordinates(-1,0));
        for( Coordinates m : moves )
            if(pos.x+m.x > 0 && pos.x+m.x < boardXsize && pos.y+m.y > 0 && pos.y+m.y < boardYsize)
                result.add(new Coordinates(pos.x+m.x, pos.y+ m.y, stepsRemaining));

        return  result;

    }


    public int minMoved(String[] t) {
        Queue<Coordinates> coordQueue = new LinkedList<Coordinates>();
        int totalCookiesCount = 0;
        int boardXSize = t.length;
        int boardYSize = t[0].length();

        int [][] curMin = new int [boardXSize][boardYSize];
        for( int i = 0; i < boardXSize; i++)
            for( int j = 0; j <  boardYSize; j++) {
                curMin[i][j] = Integer.MAX_VALUE;
                if(t[i].charAt(j) == '#')
                    totalCookiesCount++;
            }

        curMin[0][0] = (t[0].charAt(0) == '#')?0:1;

        coordQueue.add(new Coordinates(1,0, totalCookiesCount-1));
        coordQueue.add(new Coordinates(0,1, totalCookiesCount-1));

        while(coordQueue.size() > 0) {
            Coordinates curr = coordQueue.remove();;
            if(curr.stepsRemaining > 0) {

                ArrayList<Coordinates> neighbours = getNeighbours(curr, boardXSize, boardYSize, curr.stepsRemaining - 1);
                int min = Integer.MAX_VALUE;
                for (Coordinates c : neighbours) {
                    int cookieMod =((t[curr.x].charAt(curr.y) == '#') ? 0 : 1);
                    min = (min - cookieMod > curMin[c.x][c.y]) ? curMin[c.x][c.y] + cookieMod : min;
                }


                curMin[curr.x][curr.y] = min;

                for (Coordinates c : neighbours)
                    if (curMin[c.x][c.y] > curMin[curr.x][curr.y] + ((t[c.x].charAt(c.y) == '#') ? 0 : 1))
                        coordQueue.add(c);
            }

        }


        return ((curMin[t.length-1][t[0].length()-1] < Integer.MAX_VALUE))?curMin[t.length-1][t[0].length()-1]:-1;
    }


}


