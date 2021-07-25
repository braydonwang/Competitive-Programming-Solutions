#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, m, b;
    int a[(int)1e5+5];
    std::map<int,vector<int>> map;
    std::cin >> n;
    for (int i = 0; i < n; i++){
        std::cin >> m >> b;
        a[i] = m;
        if (count(map[m].begin(),map[m].end(),b)){
            std::cout << "Infinity" << std::endl;
            return 0;
        }
        map[m].push_back(b);
    }
    long ans = 0;
    for (int i = 0; i < n; i++){
        ans += n - map[a[i]].size();
    }
    std::cout << ans/2 << std::endl;
    return 0;
}
