/**
 * Created by Karol on 20/02/2017.
 */
public class AlphabetOrderDiv1 {

    final static int ALPHABET_SIZE = (((int)'z')-((int)'a')) + 1;

    private boolean[][] immediateLarger = new boolean[ALPHABET_SIZE][ALPHABET_SIZE];

    private class CycleException extends Exception {
        public CycleException(String message) {
            super(message);
        }
    }

    private void initLarger(String[] words) {
        for(int i = 0; i < ALPHABET_SIZE; i++) //each letter is larger or equal than itself
            immediateLarger[i][i] = true;

        for( String word : words) {
            char[] characters = word.toCharArray();
            for( int i = 0; i < characters.length-1; i++)
                immediateLarger[((int)characters[i]) - ((int) 'a')][((int)characters[i+1]- ((int) 'a'))] = true;
        }
    }

    private boolean [] findLarger(int letter, boolean[] currentlyCalculated, boolean[] calculatedEarlier,
                                 boolean[][] resultSoFar) throws CycleException {
        boolean res [] = new boolean[ALPHABET_SIZE];
        currentlyCalculated[letter] = true;


        for(int i = 0; i < ALPHABET_SIZE; i++) {

            if(i != letter && resultSoFar[letter][i]) {
                boolean[] succOfI;
                if( calculatedEarlier[i] ) {
                    succOfI = resultSoFar[i];
                }
                else
                    if( currentlyCalculated[i])
                        throw new CycleException("cycle detected");
                    else
                        succOfI = findLarger(i, currentlyCalculated, calculatedEarlier, resultSoFar);

                if( succOfI[letter] )
                    throw new CycleException("cycle detected");

                for(int q = 0; q < ALPHABET_SIZE; q++)
                    resultSoFar[letter][q] = succOfI[q] || resultSoFar[letter][q];

            }
        }
        currentlyCalculated[letter] = false;

        calculatedEarlier[letter] = true;
        return res;

    }

    public String isOrdered(String[] words) {
        initLarger(words);
        boolean[] currentlyCalculated = new boolean[ALPHABET_SIZE];
        boolean[] calculatedEarlier = new boolean[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            try {
                findLarger(i, currentlyCalculated, calculatedEarlier, immediateLarger);
            } catch (CycleException e) {
                return "Impossible";
            }
        }


        return "Possible";
    }

}
