/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import src.main.LinkStack;

public class InfixToPostfix {


    /* converts an infix arithmetic expressions to postifx arithmetic expressions
     * assumes that expr input has all parentheses by calculation order
     * */
    public static String filter(String expr) {

        LinkStack<String> operands = new LinkStack<>();
        LinkStack<String> operators = new LinkStack<>();

        String[] sArr = expr.split(" ");

        for (String s : sArr) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                operators.push(s);
            }
            else if (s.equals(")")) {

                String operand1 = operands.pop();
                String operand2 = operands.pop();
                String operator = operators.pop();
                operands.push(operand1 + " " + operand2 + " " + operator);
            }
            else if (!s.equals("(")) {
                operands.push(s);
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {

        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            StdOut.println(filter(line));
        }
    }
}
