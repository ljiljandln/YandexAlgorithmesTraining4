package warmUp;

import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1],
                            Math.min(matrix[i][j - 1], matrix[i - 1][j])) + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        System.out.print(max);
    }
}
