package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TaskB {
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

    record Sorter(int[] arr, int n) {
            Sorter(int[] arr, int n) {
                this.arr = arr;
                this.n = n;
                if (n > 1) {
                    qSort(0, n - 1);
                }
            }

            public void printRes() {
                StringBuilder sb = new StringBuilder();
                for (int el : arr) sb.append(el).append(" ");
                System.out.print(sb);
            }

            private int[] partition(int left, int right) {
                Random rnd = new Random();
                int rndIndex = left + rnd.nextInt(right - left + 1);
                int x = arr[rndIndex];

                int equal = left, greater = left;
                for (int now = left; now <= right; now++) {
                    if (arr[now] < x) {
                        int curr = arr[now];
                        arr[now] = arr[greater];
                        arr[greater++] = arr[equal];
                        arr[equal++] = curr;
                    } else if (arr[now] == x) {
                        int tmp = arr[greater];
                        arr[greater++] = arr[now];
                        arr[now] = tmp;
                    }
                }
                return new int[]{equal, greater};
            }

            private void insertionSort(int left, int right) {
                for (int i = left + 1; i <= right; i++) {
                    int k = i, tmp = arr[k];
                    while (k > left && tmp < arr[k - 1]) {
                        arr[k] = arr[k - 1];
                        k--;
                    }
                    arr[k] = tmp;
                }
            }

            private void qSort(int left, int right) {
                while (right > left) {
                    if (right - left < 16) {
                        insertionSort(left, right);
                        return;
                    } else {
                        int[] res = partition(left, right);
                        int equal = res[0], greater = res[1];
                        if (equal - left - 1 < right - greater) {
                            qSort(left, equal - 1);
                            left = greater;
                        } else {
                            qSort(greater, right);
                            right = equal - 1;
                        }
                    }
                }
            }
        }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextInt();

        Sorter sorter = new Sorter(arr, n);
        sorter.printRes();
    }
}
