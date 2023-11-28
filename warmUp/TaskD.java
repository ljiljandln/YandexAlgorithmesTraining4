package warmUp;

import java.util.HashMap;
import java.util.Scanner;

public class TaskD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr1 = sc.nextLine().toCharArray();
        char[] arr2 = sc.nextLine().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : arr1) map.put(ch, map.getOrDefault(ch, 0) + 1);

        boolean isAnagram = true;
        for (char ch : arr2) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                isAnagram = false;
                break;
            } else {
                map.replace(ch, map.get(ch) - 1);
            }
        }
        System.out.print(isAnagram ? "YES" : "NO");
    }
}
