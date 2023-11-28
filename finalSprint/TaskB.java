package finalSprint;

import java.util.Scanner;

public class TaskB {
    static class HashCalc {
        final int len;
        final String str;
        final long p = (long) Math.pow(10, 9) + 7;
        final int x = 257;
        static long[] hash1;
        static long[] hash2;
        static long[] pow;

        public HashCalc(int len, String str) {
            this.len = len;
            this.str = str;
            fillHashAndPowArray();
        }

        private void fillHashAndPowArray() {
            hash1 = new long[len];
            hash2 = new long[len];
            pow = new long[len];
            pow[0] = 1;
            for (int i = 1; i < len; i++) {
                hash1[i] = (hash1[i - 1] * x + str.charAt(i)) % p;
                hash2[i] = (hash2[i - 1] * x + str.charAt(len - i)) % p;
                pow[i] = (pow[i - 1] * x) % p;
            }
        }

        private boolean isEqual(int k, int i) {
            return (hash1[k] + hash2[len - i - 1] * pow[k]) % p == (hash2[len - i + k - 1]) % p;
        }

        public int binarySearch(int i) {
            int min = 0, max = i;
            while (min < max) {
                int middle = (min + max + 1) / 2;
                boolean ans = isEqual(middle, i);
                if (ans) {
                    min = middle;
                } else {
                    max = middle - 1;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt() + 1;
        sc.nextLine();
        String str = " " + sc.nextLine();
        HashCalc hc = new HashCalc(len, str);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < len; i++) {
            sb.append(hc.binarySearch(i)).append(" ");
        }
        System.out.println(sb);
    }
}
