#include <bits/stdc++.h>

using namespace std;

int main() {
    int c, f, s, n;
    int xi, ci, fi, si;
    char str[55];
    std::cin >> c >> f >> s;
    std::cin >> n;
    for (int i = 0; i < n; i++){
        std::cin >> xi >> ci >> fi >> si;
        std::cin.ignore();
        std::cin.getline(str,55);
        if (ci*1.0/xi <= c && fi*1.0/xi <= f && si*1.0/xi <= s){
            std::cout << str << std::endl;
        }
    }
    return 0;
}
