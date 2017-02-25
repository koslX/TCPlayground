
import java.util.Arrays;
import java.util.Comparator;


/**
 * Created by Karol on 23/02/2017.
 *
 *  solution for https://community.topcoder.com/stat?c=problem_statement&pm=11502
 *
 */
public class YetAnotherIncredibleMachine {

    public int countWays(int[] platformMount, int[] platformLength, int[] balls) {


        Arrays.sort(balls);
        int[][] platforms = new int[platformMount.length][2];
        for (int i = 0; i < platformMount.length; i++) {
            platforms[i][0] = platformMount[i];
            platforms[i][1] = platformLength[i];
        }

        Arrays.sort(platforms, Comparator.comparingInt(a -> a[0]));

        int leftBall;
        int rightBall;
        long combinations = 1;
        int platform = 0;
        int ball = 0;
        while (platform < platformMount.length) {
            while (ball < balls.length && balls[ball] < platforms[platform][0])
                ball++;

            rightBall = (ball < balls.length)?balls[ball]:20001;
            leftBall = (ball>0)?balls[ball-1]:-20001;

            if((rightBall-leftBall) < platforms[platform][1]+1)
                return 0;

            int distLeft = Math.min(platforms[platform][0] - leftBall-1,platforms[platform][1]);
            int distRight = Math.min(rightBall - platforms[platform][0]-1, platforms[platform][1]);
            combinations = (combinations*(distLeft+distRight-(platforms[platform][1])+1)) % 1000000009;

            if(combinations < 1)
                return 0;
            platform++;
        }

        return (int)combinations;
    }

}

