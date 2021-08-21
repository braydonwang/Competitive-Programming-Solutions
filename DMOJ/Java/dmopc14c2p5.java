import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			adj[readInt()].add(readInt());
		}
		double[] dp = new double[n+1];
		dp[1] = 1.0;
		for (int i = 1; i <= n; i++) {
			double p = dp[i] / adj[i].size();
			for (int nxt: adj[i]) {
				dp[nxt] += p;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (adj[i].size() == 0) {
				System.out.println(dp[i]);
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
