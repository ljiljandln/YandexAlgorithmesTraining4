package day2;

import java.util.Scanner;

public class TaskC {

    static class HashCalc {
        final String str;
        final int len;
        final long p = (long) Math.pow(10, 9) + 7;
        final int x = 257;
        long[] hash;
        long[] pow;

        public HashCalc(String str) {
            this.str = str;
            len = str.length();
            fillHashAndPowArray();
        }

        private void fillHashAndPowArray() {
            hash = new long[len];
            pow = new long[len];
            pow[0] = 1;
            for (int i = 1; i < len; i++) {
                hash[i] = (hash[i - 1] * x + str.charAt(i)) % p;
                pow[i] = (pow[i - 1] * x) % p;
            }
        }

        private boolean isEqual(int b, int l) {
            return (hash[l] + hash[b - 1] * pow[l]) % p ==
                    (hash[b + l - 1] + hash[0] * pow[l]) % p;
        }

        private int binarySearch(int i) {
            int min = 1, max = len - i;
            int res = 0;
            while (max >= min) {
                int middle = (min + max) / 2;
                if (isEqual(i, middle)) {
                    res = middle;
                    min = middle + 1;
                } else {
                    max = middle - 1;
                }
            }
            return res;
        }

        public void calcZFunc() {
            StringBuilder sb = new StringBuilder();
            sb.append(0);
            for (int i = 2; i < len; i++) {
                sb.append(" ");
                sb.append(binarySearch(i));
            }
            System.out.print(sb);
        }
    }

    public static void main(String[] args) {
        String str = " " + new Scanner(System.in).nextLine();

        HashCalc hashCalc = new HashCalc(str);
        hashCalc.calcZFunc();
    }
}
