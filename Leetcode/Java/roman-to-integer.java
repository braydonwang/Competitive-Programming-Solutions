class Solution {
    public int romanToInt(String s) {
        char[] a = {'I','V','X','L','C','D','M'};
        int[] b = {1,5,10,50,100,500,1000};
        int[] c = {0,4,9,40,90,400,900};
        int n = s.length();
        char[] str = new char[n];
        for (int i = 0; i < n; i++){
            str[i] = s.charAt(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            int ind1 = getIndex(a,str[i]);
            if (i == n-1){
                ans += b[ind1];
            } else {
                int ind2 = getIndex(a,str[i+1]);
                if (ind2 > ind1){
                    ans += c[ind2];
                    i++;
                } else {
                    ans += b[ind1];
                }
            }
        }
        return ans;
    }
    public int getIndex(char[] array, char ch){
        for (int i = 0; i < array.length; i++){
            if (array[i] == ch){
                return i;
            }
        }
        return -1;
    }
}
