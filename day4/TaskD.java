package day4;

import java.util.Scanner;

public class TaskD {
    static int[][] graph;
    static int n;
    static int best = Integer.MAX_VALUE;
    static int[] minArr;

    static void func(int curr, boolean[] visited, int res, int count) {
        boolean[] newVisited = new boolean[n + 1];
        if (curr != 1) {
            System.arraycopy(visited, 0, newVisited, 0, n + 1);
            newVisited[curr] = true;
            count++;
        }
        for (int i = 1; i <= n; i++) {
            if (!newVisited[i] && !(i == 1 && count < n - 1) && graph[curr][i] != 0) {
                int len = graph[curr][i];
                int minLen = getMin(i, newVisited);
                if (i == 1 && count == n - 1) {
                    best = Math.min(best, res + len);
                } else if (res + len + minLen <= best) {
                    func(i, newVisited, res + len, count);
                }
            }
        }
    }

    static int getMin(int curr, boolean[] visited) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] || i == curr) continue;
            res += minArr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        if (n == 1) {
            System.out.print(sc.nextInt() * 2);
        } else {
            graph = new int[n + 1][n + 1];
            minArr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= n; j++) {
                    int len = sc.nextInt();
                    graph[i][j] = len;
                    if (i != j) min = Math.min(min, len);
                }
                minArr[i] = min;
            }

            boolean[] visited = new boolean[n + 1];
            func(1, visited, 0, 0);
            System.out.print(best == Integer.MAX_VALUE ? -1 : best);
        }
    }
}
