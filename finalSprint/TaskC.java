package finalSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskC {
    static final int TRACK_WEIGHT = 3_000_000;
    static final int PLATE_WEIGHT = 100;
    static final int PLATE_COUNT = 10_000_000;
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

    record Data(int weight, int time) {}

    record Edge(int to, Data data) {}

    static class GraphCalc {
        final int vertexCount;
        final ArrayList<Edge>[] graph;
        final int maxTime = 1440;
        final int max;

        public GraphCalc(int vertexCount, ArrayList<Edge>[] graph, int max) {
            this.vertexCount = vertexCount;
            this.graph = graph;
            this.max = max;
        }

        int binarySearch() {
            int left = 0, right = max;
            while (left < right) {
                int middle = (left + right + 1) / 2;
                if (dijkstra(middle)) {
                    left = middle;
                } else {
                    right = middle - 1;
                }
            }
            return left;
        }

        private boolean dijkstra(int weight) {
            int[] time = new int[vertexCount + 1];
            boolean[] visited = new boolean[vertexCount + 1];
            Arrays.fill(time, Integer.MAX_VALUE);

            time[1] = 0;
            int nearest = 1;
            while (nearest != vertexCount) {
                for (Edge edge : graph[nearest]) {
                    if (edge.data.weight < weight) continue;
                    if (time[edge.to] > time[nearest] + edge.data.time) {
                        time[edge.to] = time[nearest] + edge.data.time;
                    }
                }
                visited[nearest] = true;

                nearest = -1;
                for (int v = 1; v <= vertexCount; v++) {
                    if (!visited[v] && (nearest == -1 || time[nearest] > time[v])) {
                        nearest = v;
                    }
                }
                if (nearest == -1) break;
            }
            return time[vertexCount] <= maxTime;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        int vertexCount = fs.nextInt(), roadCount = fs.nextInt();
        if (vertexCount == 1) {
            System.out.print(PLATE_COUNT);
        } else {
            ArrayList<Edge>[] graph = new ArrayList[vertexCount + 1];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < roadCount; i++) {
                int a = fs.nextInt(), b = fs.nextInt();
                int time = fs.nextInt(), weight = fs.nextInt();

                if (weight < TRACK_WEIGHT + PLATE_WEIGHT) continue;
                weight = (weight - TRACK_WEIGHT) / PLATE_WEIGHT;
                Data data = new Data(weight, time);

                max = Math.max(max, weight);

                if (graph[a] == null) graph[a] = new ArrayList<>();
                if (graph[b] == null) graph[b] = new ArrayList<>();

                graph[a].add(new Edge(b, data));
                graph[b].add(new Edge(a, data));
            }
            GraphCalc gc = new GraphCalc(vertexCount, graph, max);
            System.out.print(gc.binarySearch());
        }
    }
}
