#include <iostream>
#include <vector>
#include <set>

using namespace std;

struct Road {
  int to;
  int timeFrom;
  int timeTo;
};

int main() {
  int cityes, roads, start, end;
  cin >> cityes >> start >> end >> roads;

  vector<vector<Road>> graph(cityes + 1);
  for (int i = 0; i < roads; i++) {
    int from;
    Road road;
    cin >> from >> road.timeFrom >> road.to >> road.timeTo;
    graph[from].push_back(road);
  }

  if (!graph[start].empty()) {
    const int INF = 1e9;
    vector<int> dist(cityes + 1, INF);
    dist[start] = 0;

    set<pair<int, int>> q;
    q.insert({dist[start], start});

    while(!q.empty()) {
      int nearest = q.begin()->second;
      q.erase(q.begin());

      for (Road road : graph[nearest]) {
        if (road.timeFrom >= dist[nearest] && dist[road.to] > road.timeTo) {
          q.erase({dist[road.to], road.to});
          dist[road.to] = road.timeTo;
          q.insert({dist[road.to], road.to});
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