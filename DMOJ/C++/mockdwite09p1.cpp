#include <bits/stdc++.h>

using namespace std;

int main() {
    int l, u, count;
    for (int z = 0; z < 5; z++){
        count = 0;
        std::cin >> l >> u;
        for (int i = l; i <= u; i++){
            std::string str = std::to_string(i);
            int n = str.length();
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += str.at(j) - '0';
            }
            bool increase = true;
            for (int j = 1; j < n; j++){
                if (str.at(j) <= str.at(j-1)){
                    increase = false;
                    break;
                }
            }
            bool awesome = true;
            for (int j = 2; j*j <= i; j++){
                if (i % (j*j) == 0){
                        if (i == 6){
                            std::cout << j << std::endl;
                        }
                    awesome = false;
                    break;
                }
            }
            if (sum % 2 == 0 && increase && awesome){
                count++;
            }
        }
        std::cout << count << std::endl;
    }
    return 0;
}
