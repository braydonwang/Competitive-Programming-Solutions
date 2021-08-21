import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[][] bit;
    static int mod = (int) 1e9 + 7;
    public static void main(String[]args) throws IOException{
    	int n = readInt();
    	bit = new long[2005][2005];
    	long ans = 0;
    	for (int i = 0; i < n; i++) {
    		int temp = readInt();
    		int r = readInt(), c = readInt(), x = readInt();
    		if (temp == 1) {
    			update(c,r+c-1,x);
    		} else {
    			ans = (ans + ((query(c+x,r+c-1) % mod - query(c-1,r+c-1) % mod) % mod)) % mod;
    		}
    	}
    	System.out.println(ans);
    }
    static void update(int x, int y, int val) {
    	for (int i = x; i < 2005; i += i & -i) {
    		bit[y][i] += val;
    	}
    }
    static long query(int x, int y) {
    	long sum = 0;
    	for (int i = x; i > 0; i -= i & -i) {
    		sum += bit[y][i];
    	}
    	return sum;
    }
	static String next () throws IOException {
  	  while (st == null || !st.hasMoreTokens())
  		  st = new StringTokenizer(br.readLine().trim());
  	  return st.nextToken();
    }
    
    static long readLong () throws IOException {
  	  return Long.parseLong(next());
    }

    static int readInt () throws IOException {
  	  return Integer.parseInt(next());
    }

    static double readDouble () throws IOException {
  	  return Double.parseDouble(next());
    }
    
    static String readLine () throws IOException {
  	  return br.readLine().trim();
    } 
}
