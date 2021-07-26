import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] h;
	static int maxn = (int)3e5;
	static int logn = 20;
	static int[][] dp = new int[maxn+5][logn+2];
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < maxn+5; i++) {
			Arrays.fill(dp[i], -1);
		}
		int[] node = new int[maxn+5];
		h = new int[maxn+5];
		for (int i = 1; i <= n; i++) {
			char ch = readCharacter();
			if (ch == 'a') {
				int v = readInt();
				v = node[v];
				h[i] = h[v] + 1;
				dp[i][0] = v;
				for(int j = 1; j < logn; j++){
					if (dp[i][j-1] != -1) {
						dp[i][j] = dp[dp[i][j-1]][j-1];
					}
			    }
				node[i] = i;
			} else if (ch == 'b') {
				int v = readInt();
				node[i] = dp[node[v]][0];
				System.out.println(node[v]);
			} else {
				int v = readInt(), w = readInt();
				node[i] = node[v];
				int anc = lca(node[v],node[w]);
				System.out.println(h[anc]);
			}
		}
	}
	static int lca(int x, int y){
		if(h[x] < h[y]) {
			int z = x;
			x = y;
			y = z;
		}
	    for(int i=logn-1; i>=0; i--)
	        if(dp[x][i] !=-1 && h[dp[x][i]] >= h[y]) x = dp[x][i];
	    if(x == y) return x;
	    for(int i=logn-1; i>=0; i--)
	        if(dp[x][i]!=-1 && dp[y][i]!=-1 && dp[x][i] != dp[y][i]) {
	        	x = dp[x][i]; y = dp[y][i];
	        }
	    return dp[x][0];
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
