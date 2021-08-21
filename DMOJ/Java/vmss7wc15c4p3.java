import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		List<Edge> adj[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 1; i <= m; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Edge(v,w)); adj[v].add(new Edge(u,w));
		}
		int[] dis = new int[n];
		PriorityQueue<Edge> q = new PriorityQueue();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0; q.add(new Edge(0,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (dis[e.v] > dis[cur.v] + e.w) {
					dis[e.v] = dis[cur.v] + e.w;
					q.add(new Edge(e.v, dis[e.v]));
				}
			}
		}
		int[] dis2 = new int[n];
		Arrays.fill(dis2, Integer.MAX_VALUE);
		dis2[n-1] = 0; q.add(new Edge(n-1,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (dis2[e.v] > dis2[cur.v] + e.w) {
					dis2[e.v] = dis2[cur.v] + e.w;
					q.add(new Edge(e.v,dis[e.v]));
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dis[i] + dis2[i]);
		}
		System.out.println(max);
	}
	static class Edge implements Comparable<Edge> {
		int v, w;
		Edge(int v0, int w0){
			v=v0;
			w=w0;
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
