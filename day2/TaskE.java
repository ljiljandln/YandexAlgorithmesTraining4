package day2;

import java.util.Scanner;

public class TaskE {

    static class HashCalc {
        final String str;
        final int len;
        final long p = (long) Math.pow(10, 9) + 7;
        final int x = 257;
        long[] hash1;
        long[] hash2;
        long[] pow;

        public HashCalc(String str) {
            this.str = str;
            len = str.length();
            fillHashArray();
        }

        void fillHashArray() {
            hash1 = new long[len];
            hash2 = new long[len];
            pow = new long[len];
            pow[0] = 1;
            for (int i = 1; i < len; i++) {
                pow[i] = (pow[i - 1] * x) % p;
                hash2[i] = (hash2[i - 1] * x + str.charAt(len - i)) % p;
                hash1[i] = (hash1[i - 1] * x + str.charAt(i)) % p;
            }
        }

        private boolean isEqual(int i, int l) {
            int a = i - l + 1;
            int b = len - i - l + 1;
            return (hash1[a + l - 1] + hash2[b - 1] * pow[l]) % p ==
                    (hash2[b + l - 1] + hash1[a - 1] * pow[l]) % p;
        }

        public int binarySearch(int i) {
            int min = 1, max = Math.min(i, len - i - 1);
            int res = 1;
            while (max >= min) {
                int middle = (min + max) / 2;
                boolean ans = isEqual(i, middle);
                if (ans) {
                    res = middle;
                    min = middle + 1;
                } else {
                    max = middle - 1;
                }
            }
            if (str.charAt(i) == '@') res--;
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append(' ');
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("@");
        }
        HashCalc hc = new HashCalc(sb.toString());

        long res = 0L;
        for (int i = 1; i < hc.len; i++) {
            res += (hc.binarySearch(i) + 1) / 2;
        }
        System.out.print(res);
    }
}
