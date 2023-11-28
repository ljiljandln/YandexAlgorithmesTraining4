package warmUp;

import java.util.Scanner;

public class TaskH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int div = b / n;
        if (b % n != 0) div++;

        System.out.print((a > div) ? "Yes" : "No");
    }
}
