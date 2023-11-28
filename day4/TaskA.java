package day4;

import java.util.Scanner;

public class TaskA {
    static int[] arr;
    static int n;
    static final StringBuilder sb = new StringBuilder();

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    static boolean toMakeTransfer() {
        int j = n - 2;
        while (j >= 0 && arr[j] >= arr[j + 1]) j--;
        if (j < 0) return false;
        int k = n - 1;
        while (arr[j] >= arr[k]) k--;
        swap(j, k);
        int l = j + 1, r = n - 1;
        while (l < r) swap(l++, r--);
        return true;
    }

    static void write() {
        for (int el : arr) {
            sb.append(el);
        }
       sb.append("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;

        write();
        while (toMakeTransfer()) write();
        System.out.print(sb);
    }
}
