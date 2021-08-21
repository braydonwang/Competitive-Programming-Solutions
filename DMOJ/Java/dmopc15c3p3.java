import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] vis;
	static ArrayList<Integer> adj[];
	static boolean done;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		done = false;
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		vis = new boolean[n+1];
		for (int i = 1; i <= n-5; i++) {
			dfs(i, i, 0);
		}
		if (done) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	static void dfs(int u, int start, int dis) {
		vis[u] = true;
		for (int v: adj[u]) {
			if (v == start && dis == 5) {
				done = true;
				return;
			}
			if (!vis[v]) {
				dfs(v,start,dis+1);
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
