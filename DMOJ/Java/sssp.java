import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Edge(v,w)); adj[v].add(new Edge(u,w));
		}
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		boolean[] vis = new boolean[n+1];
		dis[1] = 0;
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE, id = -1;
			for (int j = 1; j <= n; j++) {
				if (dis[j] < min && !vis[j]) {
					min = dis[j];
					id = j;
				}
			}
			if (id == -1) {
				break;
			}
			vis[id] = true;
			for (Edge e: adj[id]) {
				if (dis[e.v] > dis[id] + e.w) {
					dis[e.v] = dis[id] + e.w; 
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (vis[i]) {
				System.out.println(dis[i]);
			} else {
				System.out.println(-1);
			}
		}
	}
	static class Edge implements Comparable<Edge>{
		int v, w;
		Edge(int v, int w){
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge e) {
			return this.w - e.w;
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
