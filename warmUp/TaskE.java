package warmUp;

import java.util.Scanner;

public class TaskE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.print(0);
        } else if (n == 2) {
            System.out.print(Math.abs(sc.nextInt() - sc.nextInt()));
        } else {
            int[] arr = new int[n];
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i] - arr[0];
            }
            sb.append(sum).append(" ");

            for (int i = 1; i < n; i++) {
                int diff = arr[i] - arr[i - 1];
                int minus = n - 1 - i;
                int plus = n - 2 - minus;

                sum = sum - minus * diff + plus * diff;
                sb.append(sum).append(" ");
            }

            System.out.print(sb);
        }
    }
}
