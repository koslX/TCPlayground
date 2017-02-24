package koper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CutKoper
{
    final static int PERFECT_LENGTH = 10;

    public int getMaximum(int[] eelLengths, int maxCuts) {
        final List<Integer> eels = Arrays.stream(eelLengths)
            .boxed()
            .sorted(Comparator.comparing((Integer v) -> v % PERFECT_LENGTH).thenComparing(Comparator.naturalOrder()))
            .collect(Collectors.toList());
        int cutsLeft = maxCuts;
        int piecesReady = 0;

        for (int eel : eels) {
            int maxPieces = eel / PERFECT_LENGTH;
            int eelMaxCuts = maxPieces - (eel % PERFECT_LENGTH == 0 ? 1 : 0);

            if (cutsLeft >= eelMaxCuts) {
                cutsLeft -= eelMaxCuts;
                piecesReady += maxPieces;
            } else {
                return piecesReady + cutsLeft;
            }
        }

        return piecesReady;
    }
}
