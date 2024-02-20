/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class TwoSumFast {

    public static int count(int[] a) {
        // merge sort
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (BinarySearch.rank(-a[i], a) > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int countSlow(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == 0) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch w1 = new Stopwatch();
        System.out.println(
                "Two Sum Pairs Fast: " + TwoSumFast.count(a) + ", time: " + w1.elapsedTime());

        Stopwatch w2 = new Stopwatch();
        System.out.println(
                "Two Sum Pairs Slow: " + TwoSumFast.countSlow(a) + ", time: " + w2.elapsedTime());
    }
}
