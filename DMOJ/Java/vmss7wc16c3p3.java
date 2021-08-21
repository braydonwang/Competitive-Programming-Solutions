import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), b = readInt(), k = readInt();
		List<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Edge(v,w)); adj[v].add(new Edge(u,w));
		}
		int[] dis = new int[n+1];
		PriorityQueue<Edge> q = new PriorityQueue();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[b] = 0; q.add(new Edge(b,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (dis[cur.v] + e.w < dis[e.v]) {
					dis[e.v] = dis[cur.v] + e.w;
					q.add(new Edge(e.v,dis[e.v]));
				}
			}
		}
		for (int i = 0; i < k; i++) {
			int a = readInt();
			if (dis[a] != Integer.MAX_VALUE) {
				System.out.println(dis[a]);
			}
			else {
				System.out.println(-1);
			}
		}
	}
	static class Edge implements Comparable<Edge>{
		int v, w;
		Edge(int v, int w){
			this.v=v;
			this.w=w;
		}
		public int compareTo(Edge x) {
			return w-x.w;
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
