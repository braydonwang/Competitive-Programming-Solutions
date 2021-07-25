#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    double x;
    std::cin >> n;
    for (int i = 0; i < n; i++){
        std::cin >> x;
        if (x < 34){
            std::cout << "Too cold, please try again." << std::endl;
        } else if (x <= 35.5){
            std::cout << "Take a hot bath." << std::endl;
        } else if (x <= 38){
            std::cout <<  "Rest if feeling unwell." << std::endl;
        } else if (x <= 39){
            std::cout << "Take some medicine."  << std::endl;
        } else if (x <= 41){
            std::cout <<  "Take a cold bath and some medicine." << std::endl;
        } else if (x <= 46.1){
            std::cout <<  "Go to the hospital." << std::endl;
        } else if (x <= 50){
            std::cout <<  "Congrats, you have a new world record!" << std::endl;
        } else {
            std::cout << "Too hot, please try again."  << std::endl;
        }
    }
    return 0;
}
