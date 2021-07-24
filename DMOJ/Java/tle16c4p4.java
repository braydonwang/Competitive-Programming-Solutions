import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Edge> adj[];
	static boolean[] vis;
	static long max = 0;
	static int node = 0;
	static Edge[] prev;
	static long max1 = 0, max2 = 0;
	static int far1 = 0, far2 = 0;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), q = readInt();
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int u = readInt(), v = readInt(), l = readInt();
			adj[u].add(new Edge(v,l)); adj[v].add(new Edge(u,l));
		}
		vis = new boolean[n+1];
		prev = new Edge[n+1];
		if (q == 1) {
			long ans = 0; int count = 0;
			for (int i = 1; i <= n; i++) {
				if (!vis[i]) {
					max = 0; node = i;
					count++;
					dfs(i,-1,0);
					max = 0;
					dfs(node,-1,0);
					ans += max;
				}
			}
			System.out.println(ans + count - 1);
		} else {
			long rad = 0;
			for (int i = 1; i <= n; i++) {
				if (!vis[i]) {
					max1 = 0; far1 = i; max2 = 0; far2 = i;
					dfs2(i,-1,0);
					prev[far1] = new Edge(-1,0);
					dfs3(far1,-1,0);
					//System.out.println(far2 + " " + far1);
					long count = 0;
					long r = (long)1e12;
					while (prev[far2].v != -1) {
			        	count += prev[far2].w;
			        	r = Math.min(r, Math.max(count, max2-count));
			        	far2 = prev[far2].v;
			        }
					if (r == 1e12) {
						r = 0;
					}
					if (r > rad) {
						rad = r;
					} else if (r == rad) {
						rad = r + 1;
					}
				}
			}
			System.out.println(rad);
		}
	}
	static void dfs3(int u, int pre, long dis) {
		vis[u] = true;
		if (dis > max2) {
			max2 = dis;
			far2 = u;
		}
		for (Edge e: adj[u]) {
			if (e.v != pre) {
				prev[e.v] = new Edge(u,e.w); 
				dfs3(e.v,u,dis+e.w);
			}
		}
	}
	static void dfs2(int u, int pre, long dis) {
		vis[u] = true;
		if (dis > max1) {
			max1 = dis;
			far1 = u;
		}
		for (Edge e: adj[u]) {
			if (e.v != pre) {
				dfs2(e.v,u,dis+e.w);
			}
		}
	}
	static void dfs(int u, int pre, long dis) {
		vis[u] = true;
		if (dis > max) {
			max = dis;
			node = u;
		}
		for (Edge e: adj[u]) {
			if (e.v != pre) {
				dfs(e.v,u,dis+e.w);
			}
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
