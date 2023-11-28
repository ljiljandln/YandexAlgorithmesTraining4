package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskA {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static void swapArray(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    static int partition(int[] arr, int k, int left, int right) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return (arr[0] < k) ? 1 : 0;

        int i = left, j = right;

        while (i <= j) {
            while(i <= right && arr[i] < k) i++;
            while (j >= left && arr[j] >= k) j--;
            if (i == arr.length) return arr.length;
            if (j == -1) return 0;
            if (i <= j) {
                swapArray(arr, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextInt();

        int k = fs.nextInt();
        int number = partition(arr, k, 0, n - 1);
        System.out.println(number);
        System.out.print(n - number);
    }
}
