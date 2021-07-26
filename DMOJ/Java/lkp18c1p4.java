import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[][] array = new int[m][3];
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int d = readInt(), e = readInt(), f = readInt();
			array[i][0] = d; array[i][1] = e; array[i][2] = f;
		}
		int a = readInt(), b = readInt();
		long c = readLong();
		
		ArrayList<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			adj[array[i][0]].add(new Edge(array[i][1],array[i][2]));
			adj[array[i][1]].add(new Edge(array[i][0],array[i][2]));
			if (find(array[i][0]) != find(array[i][1])) {
				union(array[i][0],array[i][1]);
			}
			if (find(a) == find(b)) {
				long[] dis = new long[n+1];
				PriorityQueue<Edge> q = new PriorityQueue();
				Arrays.fill(dis, Long.MAX_VALUE);
				dis[a] = 0; q.add(new Edge(a,0));
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
				if (dis[b] < c) {
					System.out.println(i+1);
					return;
				}
			}
		}
		System.out.println(-1);
	}
	static class Edge implements Comparable<Edge>{
		int v;
		long w;
		Edge(int v, long w){
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge e) {
			return (int) (this.w - e.w);
		}
	}
	public static int find(int v) {
		if (parent[v] == v) {
			return v;
		}
		else {
			int result = find(parent[v]);
			parent[v] = result;
			return result;
		}
	}
	public static void union(int a, int b) {
		int arep = find(a);
		int brep = find(b);
		parent[arep] = brep;
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
