import java.util.Arrays;

/**
 * Created by Karol on 12/03/2017.
 *
 * Solution for https://community.topcoder.com/stat?c=problem_statement&pm=11154&rd=14435
 *
 */
public class SlimeXSlimesCity {
    public int merge(int[] population) {
        int result = 0;
        long partialSum = 0;
        Arrays.sort(population);
        for(int i = 0; i < population.length; i++) {
            if(i==0) {
                result = 1;
            }else {
                if(population[i-1]==population[i] || partialSum >= population[i]) {
                    result += 1;
                } else
                    result = 1;
            }
            partialSum += population[i];

        }
        return result;
    }
}
