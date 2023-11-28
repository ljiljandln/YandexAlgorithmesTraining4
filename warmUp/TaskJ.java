package warmUp;

import java.util.Scanner;

public class TaskJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            long n = sc.nextLong();
            long left = sc.nextLong();
            long right = sc.nextLong();

            if (n % left <= (n / left) * (right - left)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
