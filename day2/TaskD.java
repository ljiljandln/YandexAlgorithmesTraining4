package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

    static class HashCalc {
        int[] arr;
        final int len;
        final long p = (long) Math.pow(10, 9) + 7;
        final int x = 257;
        static long[] hash1;
        static long[] hash2;
        static long[] pow;

        public HashCalc(int[] arr, int len) {
            this.arr = arr;
            this.len = len;
            fillHashArray();
        }

        private void fillHashArray() {
            int maxIndex = (len + 1) / 2;
            hash1 = new long[maxIndex];
            hash2 = new long[len - 1];
            pow = new long[len - 1];
            pow[0] = 1;
            for (int i = 1; i < len - 1; i++) {
                pow[i] = (pow[i - 1] * x) % p;
                hash2[i] = (hash2[i - 1] * x + arr[len - i]) % p;
                if (i < (len + 1) / 2) hash1[i] = (hash1[i - 1] * x + arr[i]) % p;
            }
        }

        public boolean isEqual(int l) {
            return (hash1[l] + hash2[len - 2 * l - 1] * pow[l]) % p == (hash2[len - l - 1]) % p;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        int len = fs.nextInt() + 1;
        fs.nextInt();

        int[] arr = new int[len];
        for (int i = 1; i < len; i++) {
            arr[i] = fs.nextInt();
        }

        HashCalc hc = new HashCalc(arr, len);
        StringBuilder sb = new StringBuilder();
        for (int i = (len - 1) / 2; i >= 1; i--) {
            if (hc.isEqual(i)) sb.append(len - i - 1).append(" ");
        }
        sb.append(len - 1);
        System.out.print(sb);
    }
}
