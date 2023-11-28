package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TaskC {
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

    static LinkedList<Integer> merge(LinkedList<Integer> lst1, LinkedList<Integer> lst2) {
        LinkedList<Integer> resLst = new LinkedList<>();
        while (!lst1.isEmpty() && !lst2.isEmpty()) {
            if (lst1.get(0) >= lst2.get(0)) {
                resLst.add(lst2.pollFirst());
            } else {
                resLst.add(lst1.pollFirst());
            }
        }
        resLst.addAll(lst1);
        resLst.addAll(lst2);
        return resLst;
    }

    static LinkedList<Integer> getList(FastScanner fs) {
        int count = fs.nextInt();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            res.addLast(fs.nextInt());
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        LinkedList<Integer> list1 = getList(fs);
        LinkedList<Integer> list2 = getList(fs);

        LinkedList<Integer> res = merge(list1, list2);

        StringBuilder sb = new StringBuilder();
        for (int el : res) sb.append(el).append(" ");
        System.out.print(sb);
    }
}
