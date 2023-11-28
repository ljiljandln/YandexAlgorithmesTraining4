#include <iostream>

using namespace std;

int main() {
  unsigned long long k;
  unsigned long long n;
  unsigned long long floors[n + 1];

  cin >> k >> n;
  for (int i = 1; i <= n; i++) {
    cin >> floors[i];
  }

  unsigned long long res = 0;
  for (int i = n; i > 0; i--) {
    unsigned long long capacity = k;
    res += (floors[i] / k) * i * 2L;
    capacity -= floors[i] % k;

    if (capacity != k) {
      res += i * 2L;
      while (capacity > 0 && i > 0) { 
        i--;
        if (floors[i] <= capacity) {
          capacity -= floors[i];
        } else {
          floors[i] -= capacity;
          i++;
          break;
        }
      }
    }
  }
  cout << res;
}