package day2;

import java.util.Scanner;

public class TaskB {
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

        public void calcLength() {
            for (int l = 1; l < len; l++) {
                boolean isOk = true;
                int b = 1 + l;
                for (; b + l < len; b += l) {
                    if (!isEqual(1, b, l)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    int dif = len - b;
                    if (isEqual(1, b, dif)) {
                        System.out.print(l);
                        break;
                    }
                }
            }
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

        private boolean isEqual(int a, int b, int l) {
            return (hash[a + l - 1] + hash[b - 1] * pow[l]) % p ==
                    (hash[b + l - 1] + hash[a - 1] * pow[l]) % p;
        }
    }

    public static void main(String[] args) {
        String str = " " + new Scanner(System.in).nextLine();

        HashCalc hashCalc = new HashCalc(str);
        hashCalc.calcLength();
    }
}
