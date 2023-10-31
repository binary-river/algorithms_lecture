/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package src.main;


import edu.princeton.cs.algs4.StdIn;

public class Test {
    public static void main(String[] args) {

        // System.out.println("input bottom : ");
        // double bottom = StdIn.readDouble();
        //
        // System.out.println("input height : ");
        // double height = StdIn.readDouble();
        //
        // double result = getHypotenuse(bottom, height);
        // System.out.println("result : " + result);

        System.out.println("input N : ");
        int n = StdIn.readInt();
        double result = H(n);
        System.out.println("result : " + result);

    }


    public static double getHypotenuse(double bottom, double height) {
        return Math.sqrt(bottom * bottom + height * height);
    }

    public static double H(int N) {
        double sum = 0.0;
        for (int i = 1; i <= N; i++)
            sum += 1.0 / i;
        return sum;
    }
}
