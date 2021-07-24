import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int MM = (int)3e5+5, mod = (int)1e9+7;
	static ArrayList<Integer> adj[];
	static long[] dp;
	static long ans;
	static int[] val;
	public static void main(String[] args) throws IOException {
		int n = readInt(); String str = next();
		val = new int[MM]; dp = new long[MM]; char[] s = new char[MM];
		for (int i = 1; i <= n; i++) {
			s[i] = str.charAt(i-1);
			if (s[i] == 'R') {
				val[i] = 1;
			}
		}
		adj = new ArrayList[MM];
		for (int i = 0; i < MM; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 1; i < n; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v); adj[v].add(u);
		}
		dfs(1,0,1); dfs(1,0,0);
		System.out.println(ans);
	}
	static void dfs(int u, int pa, int color) {
		long sum = 0, join = 0;
		for (int v: adj[u]) {
			if (v == pa) {
				continue;
			}
			dfs(v,u,color);
			join = (join + (sum + join) * dp[v]) % mod;
			sum = (sum + dp[v]) % mod;
		}
		if (val[u] == color) {
			dp[u] = (1 + sum + join) % mod;
			ans = (ans + dp[u]) % mod;
		} else {
			ans = (ans + join) % mod;
			dp[u] = (sum + join) % mod;
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
