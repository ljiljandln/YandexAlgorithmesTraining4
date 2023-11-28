package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TaskE {
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

    static class Sorter {
        String[] arr;
        final int n;
        final int count;
        final String del = "**********";

        public Sorter(String[] arr, int n, int count) {
            this.arr = arr;
            this.n = n;
            this.count = count;
        }

        int getDigit(String str, int step) {
            return Integer.parseInt(String.valueOf(str.charAt(step)));
        }

        public void sort() {
            for (int step = count - 1; step >= 0; step--) {
                counterSort(step);
            }
        }

        private void counterSort(int step) {
            ArrayList<String>[] buckets = new  ArrayList[10];
            for(int i = 0; i < 10; i++) buckets[i] = new ArrayList<>();
            int[] count = new int[10];
            for (String current : arr) {
                int digit = getDigit(current, step);
                buckets[digit].add(current);
                count[digit]++;
            }
            printBuckets(buckets, step);

            int[] pos = new int[10];
            for (int i = 1; i < 10; i++) {
                pos[i] = pos[i - 1] + count[i - 1];
            }

            String[] sortArray = new String[n];
            for (int i = 0; i < n; i++) {
                String current = arr[i];
                int digit = getDigit(current, step);

                sortArray[pos[digit]] = current;
                pos[digit]++;
            }
            arr = sortArray;
        }

        public void printRes() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]);
                if (i != n - 1) sb.append(", ");
            }
            System.out.print(sb);
        }

        private void printBuckets(ArrayList<String>[] buckets, int step) {
            System.out.printf("Phase %d\n", count - step);
            for (int i = 0; i < 10; i++) {
                ArrayList<String> list = buckets[i];
                System.out.printf("Bucket %d: %s\n", i, list.isEmpty() ? "empty" : getList(list));
            }
            System.out.println(del);
        }

        private String getList(ArrayList<String> list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) sb.append(", ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = fs.next();

        Sorter sorter = new Sorter(arr, n, arr[0].length());

        System.out.println("Initial array:");
        sorter.printRes();
        System.out.println();
        System.out.println(sorter.del);

        sorter.sort();
        System.out.println("Sorted array:");
        sorter.printRes();
    }
}
