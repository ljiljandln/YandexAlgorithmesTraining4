package warmUp;

import java.util.Scanner;
import java.util.Stack;

public class TaskI {
    static boolean isFine(char[] arr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : arr) {
            if (ch == '('){
                stack.push(')');
            } else if (ch =='{') {
                stack.push('}');
            } else if (ch =='[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();

        System.out.print(isFine(arr) ? "yes" : "no");
    }
}
