/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package prac;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import src.main.LinkStack;

import java.util.List;

public class FillParentheses {

    /* With standard input of arithmetic expression wihtout left parentheses
       Fill matched left parentheses for right parentheses
     */

    public static void main(String[] args) {

        LinkStack<String> operators = new LinkStack<>();
        LinkStack<String> operands = new LinkStack<>();
        List<String> standards = List.of("+", "-", "*", "/");

        String s = StdIn.readLine();
        String[] sArr = s.split(" ");

        StdOut.println("========================");
        StdOut.println("s : " + s);

        for (String t : sArr) {
            if (standards.contains(t)) {
                operators.push(t);
            }
            else if (t.equals(")")) {
                String operand2 = operands.pop();
                String operand1 = operands.pop();
                String operator = operators.pop();
                operands.push("( " + operand1 + " " + operator + " " + operand2 + " )");
            }
            else {
                operands.push(t);
            }
        }

        StdOut.println(operands.pop());
    }
}
