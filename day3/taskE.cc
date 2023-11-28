#include <iostream>
#include <vector>
#include <set>

using namespace std;

int main() {
  int vertexCount;
  cin >> vertexCount;

  vector<pair<double, double>> data(vertexCount + 1);
  for (int i = 1; i <= vertexCount; i++) {
    double time, speed;
    cin >> time >> speed;
    data[i] = {time, speed};
  }

  vector<vector<pair<int, double>>> graph(vertexCount + 1);
  for (int i = 0; i < vertexCount - 1; i++) {
    int a, b;
    double weight;
    cin >> a >> b >> weight;
    graph[a].push_back({b, weight});
    graph[b].push_back({a, weight});
  }
  
  const double INF = 1e9;
  vector<vector<double>> dist(vertexCount + 1, vector<double> (vertexCount + 1, INF));

  
  for (int start = 1; start <= vertexCount; start++) {
    dist[start][start] = 0;
    set<pair<double, int>> q;
    q.insert({dist[start][start], start});
    while(!q.empty()) {
      int nearest = q.begin()->second;
      q.erase(q.begin());

      for (auto &[to, weight] : graph[nearest]) {
        if (dist[start][to] > dist[start][nearest] + weight) {
          q.erase({dist[start][to], to});
          dist[start][to] = dist[start][nearest] + weight;
          q.insert({dist[start][to], to});
        }
      }
    } 
  }

  vector<double> time(vertexCount + 1);
  for (int i = 2; i <= vertexCount; i++) {
    time[i] = dist[1][i] / data[i].second + data[i].first; 
  }

  vector<vector<int>> transfer(vertexCount + 1);
  vector<bool> visited(vertexCount + 1);
  for (int i = 2; i <= vertexCount; i++) {
    int nearest = -1;
    for (int j = 2; j <= vertexCount; j++) {
      if (!visited[j] && (nearest == -1 || time[j] < time[nearest])) {
        nearest = j;
      }
    }
    visited[nearest] = true;

    for (int j = 2; j <= vertexCount; j++) {
      if (time[j] > time[nearest] + dist[j][nearest] / data[j].second + data[j].first) {
        time[j] = time[nearest] + dist[j][nearest] / data[j].second + data[j].first;
        if (!transfer[j].empty()) transfer[j].pop_back();
        transfer[j].push_back(nearest);
      }
    }
  }

  int maxVertex;
  double maxTime = -1.0;
  for (int i = 2; i <= vertexCount; i++) {
    if (time[i] > maxTime) {
      maxTime = time[i];
      maxVertex = i;
    }
  }

  printf("%.10lf\n", maxTime);
  cout << maxVertex << " ";
  while (!transfer[maxVertex].empty()) {
    for (int i = 0; i < transfer[maxVertex].size(); i++) {
      cout << transfer[maxVertex][i] << " ";
    }
    maxVertex = transfer[maxVertex][transfer[maxVertex].size() - 1];
  }
  cout << 1;
}