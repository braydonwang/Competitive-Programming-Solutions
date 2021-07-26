import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		List<Edge> adj[] = new ArrayList[n+1], rev[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList(); rev[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int u = readInt(), v = readInt();
			long w = readLong();
			adj[u].add(new Edge(v,w)); rev[v].add(new Edge(u,w));
		}
		long[] dis1 = new long[n+1], dis2 = new long[n+1];
		dijkstra(1,dis1,adj); dijkstra(n,dis2,rev);
		long ans = dis1[n]; int d = readInt();
		for (int i = 1; i <= d; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			if (dis1[u] + w + dis2[v] < ans) {
				ans = dis1[u] + w + dis2[v];
			}
		}
		System.out.println(ans >= 1e12? -1: ans);
	}
	static void dijkstra(int start, long[] dis, List<Edge> adj[]) {
		Arrays.fill(dis, (long)1e12); dis[start] = 0;
		PriorityQueue<Edge> q = new PriorityQueue();
		q.add(new Edge(start,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (dis[e.v] > dis[cur.v] + e.w) {
					dis[e.v] = dis[cur.v] + e.w;
					q.add(new Edge(e.v,dis[e.v]));
				}
			}
		}
	}
	static class Edge implements Comparable<Edge> {
		int v; long w;
		Edge(int v0, long w0){
			v=v0;
			w=w0;
		}
		public int compareTo(Edge x) {
			return Long.compare(w, x.w);
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
