package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TaskD {

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
            if (lst1.getFirst() >= lst2.getFirst()) {
                resLst.add(lst2.pollFirst());
            } else {
                resLst.add(lst1.pollFirst());
            }
        }
        resLst.addAll(lst1);
        resLst.addAll(lst2);
        return resLst;
    }

    static void printRes(LinkedList<Integer> res) {
        StringBuilder sb = new StringBuilder();
        for (int el : res) sb.append(el).append(" ");
        System.out.print(sb);
    }

    static LinkedList<Integer> mySort(LinkedList<Integer> list) {
        if (list.size() == 1 || list.isEmpty()) return list;

        LinkedList<Integer> otherList = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator();
        int i = 0;
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (i % 2 != 0) {
                otherList.addLast(item);
                iterator.remove();
            }
            i++;
        }
        list = mySort(list);
        otherList = mySort(otherList);
        return merge(list, otherList);
    }

    public static void main(String[] args) {

        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) list.addLast(fs.nextInt());

        list = mySort(list);
        printRes(list);
    }
}
