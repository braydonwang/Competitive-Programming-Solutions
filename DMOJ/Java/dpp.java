import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int mod = (int)1e9+7;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		dp = new long[n+1][2];
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		dfs(1,0);
		System.out.println((dp[1][0] + dp[1][1]) % mod);
	}
	static void dfs(int v, int p) {
		dp[v][0] = dp[v][1] = 1;
		for (int nxt: adj[v]) {
			if (nxt != p) {
				dfs(nxt,v);
				dp[v][0] = (dp[v][0] * (dp[nxt][0] + dp[nxt][1]) % mod) % mod;
				dp[v][1] = (dp[v][1] * dp[nxt][0]) % mod;
			}
		}
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
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
