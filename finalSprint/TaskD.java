package finalSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TaskD {
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

    static class BricksCalc {
        int n;
        TreeSet<Integer> set;
        ArrayList<Integer> finalList;
        int finalCount = Integer.MAX_VALUE;
        int[] arr;
        long[] prefixSum;

        public BricksCalc(int n, TreeSet<Integer> set) {
            this.n = n;
            this.set = set;

            arr = new int[set.size() * 2 + 1];
            prefixSum = new long[arr.length];
            int k = 1;
            for (int curr : set) {
                prefixSum[k] = (k > 1) ? prefixSum[k - 1] + curr : curr;
                arr[k++] = curr;
                prefixSum[k] = prefixSum[k - 1] + curr;
                arr[k++] = curr;
            }
        }

        private boolean checkCurr(int sum, int curr, ArrayList<Integer> list) {
            int diff = n - sum - curr;
            if (set.contains(diff) || (diff % 2 == 0 && set.contains(diff / 2))) {
                list.add(curr);
                if (set.contains(diff)) {
                    list.add(diff);
                } else {
                    list.add(diff / 2);
                    list.add(diff / 2);
                }
                if (list.size() < finalCount) {
                    finalList = list;
                    finalCount = list.size();
                }
                return true;
            }
            return false;
        }

        private void addList(int i, ArrayList<Integer> list) {
            for (; i < arr.length; i++) {
                list.add(arr[i]);
            }
            if (finalCount > list.size()) {
                finalList = list;
                finalCount = list.size();
            }
        }

        private void recFunc(int max, int sum, ArrayList<Integer> list) {
            for (int i = max + 1; i < arr.length; i++) {
                int curr = arr[i];
                if (sum + curr > n) continue;
                if (prefixSum[prefixSum.length - 1] - prefixSum[i] < n - sum - curr) break;
                ArrayList<Integer> newList = new ArrayList<>(list);
                if (prefixSum[prefixSum.length - 1] - prefixSum[i] == n - sum - curr) {
                    addList(i, newList);
                    break;
                } else if (!checkCurr(sum, curr, newList) && sum + curr + set.last() < n) {
                    newList.add(curr);
                    int newSum = sum + curr;
                    recFunc(i, newSum, newList);
                }
            }
        }

        public void print() {
            if (finalList == null) {
                System.out.print(0);
            } else {
                System.out.println(finalList.size());
                StringBuilder sb = new StringBuilder();
                for (int curr : finalList) sb.append(curr).append(" ");
                System.out.print(sb);
            }
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt(), m = fs.nextInt();

        long sum = 0L;
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < m; i++) {
            int curr = fs.nextInt();
            sum += 2 * curr;
            if (curr > n) {
                continue;
            }
            set.add(curr);
        }

        if (sum < n) {
            System.out.print(-1);
        } else if (set.isEmpty()) {
            System.out.print(0);
        } else {
            BricksCalc bricksCalc = new BricksCalc(n, set);
            bricksCalc.recFunc(0, 0, new ArrayList<>());
            bricksCalc.print();
        }
    }
}