#include <limits>

class Solution {
public:
    int reverse(int x) {
        int imin = std::numeric_limits<int>::min();
        int imax = std::numeric_limits<int>::max();
        bool neg = false;
        long temp = x;
        if (temp < 0){
            neg = true;
            temp *= -1;
        }
        std::string str = std::to_string(temp);
        int n = str.length();
        long y = 0;
        for (int i = n-1; i >= 0; i--){
            y = y * 10 + (str.at(i) - '0');
        }
        if (neg){
            y = -y;
        }
        if (y >= imin && y <= imax){
            return (int)y;
        } else {
            return 0;
        }
    }
};
