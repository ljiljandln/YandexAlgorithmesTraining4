package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TaskC {
    static class Graph {
        private final int[][] graph;
        private final int n;
        private int best = Integer.MIN_VALUE;
        private HashSet<Integer> bestSet;

        Graph() {
            FastScanner fs = new FastScanner(System.in);
            n = fs.nextInt();
            graph = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int len = fs.nextInt();
                    graph[i][j] = len;
                }
            }
        }

        class FastScanner {
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

        void calc() {
            for (int v = 1; v <= n; v++) {
                int len = 0;
                for (int i = 1; i <= n; i++) {
                    len += graph[v][i];
                }
                HashSet<Integer> set = new HashSet<>();
                set.add(v);
                checkBest(len, set);
                recCalc(set, 1, v, len);
            }
        }

        private void checkBest(int len, HashSet<Integer> set) {
            if (len > best) {
                best = len;
                bestSet = set;
            }
        }

        private void recCalc(HashSet<Integer> set, int step, int max, int len) {
            for (int i = max + 1; i <= n; i++) {
                HashSet<Integer> newSet = new HashSet<>(set);
                newSet.add(i);
                int len1 = calculateSet(newSet, i, len);
                if (++step < n / 2) recCalc(newSet, step--, i, len1);
            }
        }

        private int calculateSet(HashSet<Integer> set, int v, int len) {
            int[] edges = graph[v];
            for (int i = 1; i <= n; i++) {
                if (!set.contains(i)) {
                    len += edges[i];
                } else {
                    len -= edges[i];
                }
            }
            checkBest(len, set);
            return len;
        }

        void print() {
            System.out.println(best);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(bestSet.contains(i) ? 2 : 1).append(" ");
            }
            System.out.print(sb);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.calc();
        graph.print();
    }
}
