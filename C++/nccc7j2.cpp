#include <bits/stdc++.h>

using namespace std;

int main() {
    char ch, prev = 'T';
    int ans = 0;
    for (int i = 0; i < 7; i++){
        std::cin >> ch;
        if (ch == 'J' && prev == 'T') {
            ans++;
        }
        prev = ch;
    }
    std::cout << ans << std::endl;
    return 0;
}
