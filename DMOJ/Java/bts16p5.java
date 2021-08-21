import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean vis[];
	static ArrayList<Edge> adj[];
	static int[] cherries;
	static int[] cherry;
	static int[] weight;
	static int c, k, ans;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		c = readInt(); k = readInt(); ans = 0;
		adj = new ArrayList[n+1];
		vis = new boolean[n+1];
		cherry = new int[n];
		cherries = new int[n+1];
		weight = new int[n+1];
		for (int i = 0; i < n; i++) {
			cherry[i] = readInt();
		}
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt(), d = readInt();
			adj[a].add(new Edge(b,d));
			adj[b].add(new Edge(a,d));
		}
		dfs(1,(int)1e9,0);
		System.out.println(ans);
	}
	static void dfs(int v, int cost, int par) {
		weight[v] = cost; cherries[v] = cherry[v-1];
		for (Edge nxt: adj[v]) {
			int u = nxt.v, w = nxt.w;
			if (u != par) {
				dfs(u,w,v);
				cherries[v] += cherries[u]; weight[v] += weight[u];
			}
		}
		if (cherries[v] >= c && weight[v] <= k) {
			ans++;
		}
	}
	static class Edge{
		int v, w;
		Edge(int v, int w){
			this.v = v;
			this.w = w;
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
