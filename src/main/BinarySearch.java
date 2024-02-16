/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        // int lo = 0;
        // int hi = a.length - 1;
        //
        // while (lo <= hi) {
        //     int mid = lo + (hi - lo) / 2;
        //     if (key < a[mid]) hi = mid - 1;
        //     else if (key > a[mid]) lo = mid + 1;
        //     else return mid;
        // }
        //
        // return -1;

        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi) {

        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else return mid;
    }// 197

    public static int rank(int key, int[] a, int lo, int hi, int depth) {

        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println("lo:" + lo + ", hi:" + hi + ", depth:" + depth);

        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (key > a[mid]) return rank(key, a, mid + 1, hi, ++depth);
        if (key < a[mid]) return rank(key, a, lo, mid - 1, ++depth);
        return mid;
    }


    public static void main(String[] args) {


        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) != -1)
                StdOut.println("found key in whitelist! : " + key);
        }
    }

    public static void testMethod() {
        char a = '2';
        char b = '가';
        byte c = 'a';

        System.out.println("a .. " + a);
        System.out.println("b .. " + b);
        System.out.println("c .. " + c);

        TestClass1.printTest();

    }

}
