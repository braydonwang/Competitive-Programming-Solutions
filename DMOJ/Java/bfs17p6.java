import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] bit;
    static int max = 5005;
    static long[] dp;
    public static void main(String[]args) throws IOException{
    	int n = readInt();
    	bit = new int[max][max];
    	for (int i = 0; i < max; i++) {
    		Arrays.fill(bit[i], -1);
    	}
    	dp = new long[n];
    	int res = -1;
    	int[] pre = new int[n];
    	Pair[] array = new Pair[n];
    	for (int i = 0; i < n; i++) {
    		int t1 = readInt(), t2 = readInt();
    		array[i] = new Pair(Math.max(t1, t2),Math.min(t1, t2),readInt(),readInt(),i+1);
    	}
    	Arrays.sort(array);
    	for (int i = 0; i < n; i++) {
    		int temp = query(array[i].w,array[i].h);
    		if (temp == -1) {
    			dp[i] = array[i].p;
    			pre[i] = -1;
    		} else {
    			dp[i] = dp[temp] + array[i].p;
    			pre[i] = temp;
    		}
    		if (res == -1 || dp[i] > dp[res]) {
    			res = i;
    		}
    		update(array[i].w,array[i].h,i);
    	}
    	int og = res;
    	System.out.println(dp[res]);
    	int count = 0;
    	while (res != -1) {
    		count++;
    		res = pre[res];
    	}
    	System.out.println(count);
    	while (og != -1) {
    		System.out.print(array[og].ind + " ");
    		og = pre[og];
    	}
    }
    static class Pair implements Comparable<Pair>{
    	int l, w, h, p, ind;
    	Pair(int l, int w, int h, int p, int ind){
    		this.l = l;
    		this.w = w;
    		this.h = h;
    		this.p = p;
    		this.ind = ind;
    	}
    	public int compareTo(Pair p) {
    		if (this.l == p.l && this.w == p.w) {
    			return this.h - p.h;
    		} else if (this.l == p.l) {
    			return this.w - p.w;
    		}
    		return this.l - p.l;
    	}
    }
    static void update(int w, int h, int val) {
    	for (int i = w; i < max; i += i & -i) {
    		for (int j = h; j < max; j += j & -j) {
    			if (bit[i][j] == -1 || dp[bit[i][j]] < dp[val]) {
    				bit[i][j] = val;
    			}
    		}
    	}
    }
    static int query(int w, int h) {
    	int ans = -1;
    	for (int i = w; i > 0; i -= i & -i) {
    		for (int j = h; j > 0; j -= j & -j) {
    			if (bit[i][j] != -1 && (ans == -1 || dp[bit[i][j]] > dp[ans])) {
    				ans = bit[i][j];
    			}
    		}
    	}
    	return ans;
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
