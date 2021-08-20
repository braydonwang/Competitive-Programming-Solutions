import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int x = readInt(), y = readInt();
			adj[x].add(y);
		}
		boolean[] vis = new boolean[n+1];
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				dfs(i,vis,dp);
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	static void dfs(int v, boolean[] vis, int[] dp) {
		vis[v] = true;
		for (int nxt: adj[v]) {
			if (!vis[nxt]) {
				dfs(nxt,vis,dp);
			}
			dp[v] = Math.max(dp[v], dp[nxt] + 1);
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
