package finalSprint;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        long a = 1, b = 1;
        long now = 1;
        long el = 1;
        long elA = 1, elB = 1;

        while (now <= x) {
            if (elA == elB) {
                el = elA;
                elA = ++a * a;
                elB = ++b * b * b;
            } else if (elA < elB) {
                el = elA;
                elA = ++a * a;
            } else {
                el = elB;
                elB = ++b * b * b;
            }
            now++;
        }
        System.out.print(el);
    }
}
