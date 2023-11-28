package day4;

import java.util.Scanner;

public class TaskB {
    static int SIZE;
    static int RES = 0;
    static boolean[][] CAGE;

    static boolean tryDino(int a, int b) {
        for (int i = 0; i < a; i++) {
            if (CAGE[i][b]) return false;
        }
        for (int i = 1; i <= a && b - i >= 0; i++) {
            if (CAGE[a - i][b - i]) return false;
        }
        for (int i = 1; i <= a && b + i < SIZE; i++) {
            if (CAGE[a - i][b + i]) return false;
        }
        return true;
    }

    static void setDino(int a) {
        if (a == SIZE) {
            ++RES;
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (tryDino(a, i)) {
                CAGE[a][i] = true;
                setDino(a + 1);
                CAGE[a][i] = false;
            }
        }
    }

    public static void main(String[] args) {
        SIZE = new Scanner(System.in).nextInt();
        CAGE = new boolean[SIZE][SIZE];

        setDino(0);
        System.out.print(RES);
    }
}
