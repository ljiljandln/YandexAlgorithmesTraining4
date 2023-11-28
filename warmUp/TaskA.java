package warmUp;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            if (left == right || left > right || right > n) {
                sb.append("NOT FOUND").append("\n");
            } else {
                int len = right - left + 1;
                int[] segment = new int[len];
                System.arraycopy(arr, left, segment, 0, len);
                Arrays.sort(segment);
                sb.append((segment[0] != segment[len - 1]) ? segment[len - 1] : "NOT FOUND").append("\n");
            }
        }

        System.out.print(sb);
    }
}
