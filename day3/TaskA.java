package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskA {
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

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class GraphCalc {
        final ArrayList<Edge>[] graph;
        final int vertexCount;
        int[] dist;
        boolean[] visited;

        public GraphCalc(ArrayList<Edge>[] graph, int vertexCount) {
            this.graph = graph;
            this.vertexCount = vertexCount;
            dist = new int[vertexCount + 1];
            visited = new boolean[vertexCount + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
        }

        public void dijkstra(int start) {
            dist[start] = 0;
            int nearest = start;
            while (true) {
                for (Edge edge : graph[nearest]) {
                    if (dist[edge.to] > dist[nearest] + edge.weight) {
                        dist[edge.to] = dist[nearest] + edge.weight;
                    }
                }
                visited[nearest] = true;

                nearest = -1;
                for (int v = 1; v <= vertexCount; v++) {
                    if (!visited[v] && (nearest == -1 || dist[nearest] > dist[v])) {
                        nearest = v;
                    }
                }
                if (nearest == -1) break;
            }
        }

        public void printRes(int end) {
            System.out.print(dist[end] == Integer.MAX_VALUE ? -1 : dist[end]);
        }
    }


    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        int vertexCount = fs.nextInt(), start = fs.nextInt(), end = fs.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            if (graph[i] == null) graph[i] = new ArrayList<>();
            for (int j = 1; j <= vertexCount; j++) {
                if (graph[j] == null) graph[j] = new ArrayList<>();
                int weight = fs.nextInt();
                if (j != i && weight >= 0) {
                    graph[i].add(new Edge(j, weight));
                }
            }
        }

        GraphCalc gc = new GraphCalc(graph, vertexCount);
        gc.dijkstra(start);
        gc.printRes(end);
    }
}
