#include <iostream>
#include <vector>
#include <set>

using namespace std;

int main() {
  int vertexCount, edgeCount;
  cin >> vertexCount >> edgeCount;

  vector<vector<pair<int, long>>> graph(vertexCount + 1);
  for (int i = 0; i < edgeCount; i++) {
    int a, b;
    long weight;
    cin >> a >> b >> weight;

    graph[a].push_back({b, weight});
    graph[b].push_back({a, weight});
  }
  
  int start, end;
  cin >> start >> end;

  if (!graph[start].empty()) {
    const long INF = 1e18;
    vector<long> dist(vertexCount + 1, INF);
    dist[start] = 0;

    set<pair<long, int>> q;
    q.insert({dist[start], start});

    while(!q.empty()) {
      int nearest = q.begin()->second;
      q.erase(q.begin());

      for (auto &[to, weight] : graph[nearest]) {
        if (dist[to] > dist[nearest] + weight) {
          q.erase({dist[to], to});
          dist[to] = dist[nearest] + weight;
          q.insert({dist[to], to});
        }
      }
    }

    if (dist[end] != INF) {
      cout << dist[end];
    } else {
      cout << -1;
    }
  } else {
    cout << -1;
  }
}