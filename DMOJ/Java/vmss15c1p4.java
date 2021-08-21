import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt(), n = readInt(), m = readInt(), g = readInt();
		List<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		int[] array = new int[g];
		for (int i = 0; i < g; i++) {
			array[i] = readInt();
		}
		for (int i = 1; i <= m; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Edge(v,w));
		}
		int[] dis = new int[n+1];
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
					dis[e.v] = dis[cur.v]+ e.w;
					q.add(new Edge(e.v, dis[e.v]));
				}
			}
		}
		int count = 0;
		for (int i = 0; i < g; i++) {
			if (dis[array[i]] < t) {
				count++;
			}
		}
		System.out.println(count);
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
