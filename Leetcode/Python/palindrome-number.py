class Solution(object):
    def isPalindrome(self, x):
        s = str(x)
        n = len(s)
        l = 0
        r = n-1
        ans = True
        while (l < r):
            if (s[l] != s[r]):
                ans = False
                break
            l += 1
            r -= 1
        return ans
