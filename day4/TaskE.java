package day4;

import java.util.*;

public class TaskE {

    static class Generator {
        private final int n;
        private final StringBuilder finalSb = new StringBuilder();

        public Generator(int n) {
            this.n = n;
        }

        public void print() {
            rec(0, new ArrayList<>(), new StringBuilder());
            System.out.print(finalSb);
        }

        private void addOpen(int max, ArrayList<Character> list, StringBuilder sb, char ch) {
            ArrayList<Character> newList = new ArrayList<>(list);
            newList.add(ch);
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(ch);
            rec(max, newList, newSb);
        }

        private void addClosed(int max, ArrayList<Character> list, StringBuilder sb) {
            ArrayList<Character> newList = new ArrayList<>(list);
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(list.get(list.size() - 1) == '(' ? ')' : ']');
            newList.remove(list.size() - 1);
            rec(max, newList, newSb);
        }

        private void rec(int max, ArrayList<Character> list, StringBuilder sb) {
            for (int i = max + 1; i <= n; i++) {
                if (sb.length() < max || i > max + 1) return;
                if (list.size() <= n - i) {
                    addOpen(i, list, sb, '(');
                    addOpen(i, list, sb, '[');
                } else {
                    StringBuilder newSb = new StringBuilder(sb);
                    for (int k = list.size() - 1; k >= 0; k--) {
                        newSb.append(list.get(k) == '(' ? ')' : ']');
                    }
                    finalSb.append(newSb).append('\n');
                    return;
                }
                if (!list.isEmpty()) {
                    addClosed(i, list, sb);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n != 0 && n % 2 == 0) {
            Generator generator = new Generator(n);
            generator.print();
        } else {
            System.out.print("");
        }
    }
}
