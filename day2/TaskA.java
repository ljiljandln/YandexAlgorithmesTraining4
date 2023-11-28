package day2;

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

    static class HashCalc {
        final String str;
        final int len;
        long[] hash;
        long[] pow;
        final long p = (long) Math.pow(10, 9) + 7;
        final int x = 257;

        public HashCalc(String str) {
            this.str = str;
            len = str.length();
            fillHashAndPowArray();
        }

        private void fillHashAndPowArray() {
            hash = new long[len + 1];
            pow = new long[len + 1];
            pow[0] = 1;
            for (int i = 1; i < len; i++) {
                hash[i] = (hash[i - 1] * x + str.charAt(i)) % p;
                pow[i] = (pow[i - 1] * x) % p;
            }
        }

        public boolean isEqual(int a, int b, int l) {
            return (hash[a + l - 1] + hash[b - 1] * pow[l]) % p ==
                    (hash[b + l - 1] + hash[a - 1] * pow[l]) % p;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        String str = " " + fs.next();
        HashCalc hashCalc = new HashCalc(str);

        int n = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int l = fs.nextInt();
            int a = fs.nextInt();
            int b = fs.nextInt();
            sb.append(hashCalc.isEqual(a + 1, b + 1, l) ? "yes" : "no");
            if (i != n - 1) sb.append("\n");
        }
        System.out.print(sb);
    }
}
