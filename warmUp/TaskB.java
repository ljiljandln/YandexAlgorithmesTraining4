package warmUp;

import java.util.Scanner;

public class TaskB {
    static int getGcd(int x, int y) {
        while (x > 0 && y > 0) {
            if (x >= y) {
                x %= y;
            } else {
                y %= x;
            }
        }
        return Math.max(x, y);
    }

    static int getNcd(int x, int y) {
        return x * y / getGcd(x, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();
        int c = sc.nextInt(), d = sc.nextInt();

        int n = getNcd(b, d);

        int m = a * n / b + c * n / d;

        int gsd = getGcd(m, n);
        m /= gsd;
        n /= gsd;

        System.out.printf("%d %d", m, n);
    }
}
