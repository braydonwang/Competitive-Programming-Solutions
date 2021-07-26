import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		int k = readInt(), n = readInt(), m = readInt();
		ArrayList<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt(), t = readInt(), h = readInt();
			adj[a].add(new Edge(b,t,h));
			adj[b].add(new Edge(a,t,h));
		}
		int A = readInt(), B = readInt();
		int[][] dis = new int[n+1][k+1];
		PriorityQueue<Edge> q = new PriorityQueue();
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE);
		}
		dis[A][0] = 0; q.add(new Edge(A,0,0));
		boolean[][] vis = new boolean[n+1][k+1];
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (vis[cur.v][cur.h]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (e.h + cur.h < k) {
					if (dis[cur.v][cur.h] + e.w < dis[e.v][cur.h+e.h]) {
						dis[e.v][cur.h+e.h] = dis[cur.v][cur.h] + e.w;
						q.add(new Edge(e.v,dis[e.v][cur.h+e.h],cur.h+e.h));
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			if (dis[B][i] < min) {
				min = dis[B][i];
			}
		}
		if (min != Integer.MAX_VALUE) {
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
	}
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		int h;
		Edge(int v, int w, int h) {
			this.v = v;
			this.w = w;
			this.h = h;
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
