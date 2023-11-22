/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TestClass1 {

    public static void printTest() {
        System.out.println("testtest");
    }

    public static void main(String[] args) {
        // prb_1_1_1();
        // prb_1_1_3();
        // prb_1_1_7();
        // prb_1_1_8();
        // prb_1_1_9();
        // prb_1_1_11();
        // prb_1_1_12();
        // while (true) prb_1_1_14();
        // System.out.println(exR1(6));
        // prb_1_1_18();
        // while (true) prb_1_1_20();
        // prb_1_1_24();
        prb_1_1_26();
        

    }

    public static void prb_1_1_1() {
        System.out.println("1.1.1.a : " + (0 + 15) / 2);
        System.out.println("1.1.1.b : " + 2.0 * Math.exp(-6));
        System.out.println("1.1.1.c : " + (true && false || true && true));
    }

    public static void prb_1_1_3() {
        System.out.println("input..");

        int[] readInts = new int[3];
        int i = 0;
        while (!StdIn.isEmpty()) {
            readInts[i++] = StdIn.readInt();
            if (i == 3) break;
        }

        if (Arrays.stream(readInts).distinct().count() == 1) {
            System.out.println("equal!");
        }
        else {
            System.out.println("not equal!");
        }
    }

    public static void prb_1_1_7() {

        // a
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("t : %.5f \n", t);

        // b
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println("sum : " + sum);

        // c --> c code fragment has error.
    }

    public static void prb_1_1_8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    public static void prb_1_1_9() {
        System.out.println("input N");
        int N = StdIn.readInt();
        System.out.println("N is.. " + N);

        String s = "";
        for (int i = N; i > 0; i /= 2) {
            s = (i % 2) + s;
        }

        System.out.println("s : " + s);
        System.out.println("java's result : " + Integer.toBinaryString(N));
    }

    public static void prb_1_1_11() {
        boolean[][] r = { { true, false, true }, { true, true, false }, { false, false, true } };
        System.out.println("  1 2 3");

        for (int i = 0; i < r.length; i++) {
            System.out.print(i);
            for (int j = 0; j < r[0].length; j++) {
                System.out.print(" " + (r[i][j] ? "*" : " "));
            }
            System.out.println("");
        }
    }

    public static void prb_1_1_12() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++) {
            // System.out.println("a[" + i + "] : " + a[i] + ", " + "a[a[" + i + "]] : " + a[a[i]]);
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
    }

    public static void prb_1_1_14() {
        int r = StdIn.readInt();
        System.out.println("r : " + r);

        int i = 0;
        int m = 1;

        while (m < r) {
            m *= 2;
            i++;
        }
        if (m != r) i--;

        System.out.println("base-2 logarithms' integer value : " + i);
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) return "";
        return s;
    }

    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static int mystery2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }

    public static void prb_1_1_18() {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));

        System.out.println(mystery2(2, 25));
        System.out.println(mystery2(3, 11));
    }


    public static double ln(int n) {
        if (n == 1) return 0;
        return Math.log10(n) + ln(n - 1);
    }

    public static void prb_1_1_20() {
        System.out.println("input int..:");
        int N = StdIn.readInt();
        System.out.println("log10(N) : " + ln(N));
    }

    public static int gcd(int p, int q) {
        System.out.println("p : " + p + ", q : " + q);

        int r = p % q;
        if (r == 0) return q;
        return gcd(q, r);
    }

    public static void prb_1_1_24() {
        System.out.print("input num(1): ");
        int num1 = StdIn.readInt();
        System.out.print("input num(2): ");
        int num2 = StdIn.readInt();

        System.out.println("gcd : " + (num1 > num2 ? gcd(num1, num2) : gcd(num2, num1)));
    }

    public static void prb_1_1_26() {
        int[] ints = new int[3];

        for (int i = 0; i < ints.length; i++) {
            System.out.print("input " + (i + 1) + "number of numbers : ");
            ints[i] = StdIn.readInt();
            System.out.println("");
        }

        int a = ints[0];
        int b = ints[1];
        int c = ints[2];
        int t = 0;

        a = ints[0];
        b = ints[1];
        c = ints[2];

        if (a > b) {
            t = a;
            a = b;
            b = t;
        }

        if (a > c) {
            t = a;
            a = c;
            c = t;
        }

        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        System.out.println("a b c : " + a + ", " + b + ", " + c);
    }


}


