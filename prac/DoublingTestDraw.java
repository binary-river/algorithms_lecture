/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import src.main.Stopwatch;
import src.main.ZeroByThreeFast;

public class DoublingTestDraw {

    public static double timeTrial(int N) {
        final int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-MAX, MAX);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = ZeroByThreeFast.count(a);

        return timer.elapsedTime();
    }

    public static void main(String[] args) {

        VisualAccumulator visualAccumulator = new VisualAccumulator(20, 6);

        for (int N = 250; N <= 16000; N += N) {
            double time = timeTrial(N);
            double actualA = time / Math.pow(N, 3);
            StdOut.printf("%7d:: actual time: %5.1f, actual a: %e\n",
                          N, time, actualA);
            visualAccumulator.addDataValue(time);
        }
    }
}
