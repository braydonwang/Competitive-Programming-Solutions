import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] t = new int[n+1];
		for (int i = 1; i <= n; i++) {
			t[i] = readInt();
		}
		ArrayList<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			adj[a].add(new Edge(b,c)); adj[b].add(new Edge(a,c));
		}
		int[] dis = new int[n+1];
		PriorityQueue<Edge> q = new PriorityQueue();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0; q.add(new Edge(1,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (dis[e.v] > Math.max(dis[cur.v],e.w)) {
					dis[e.v] = Math.max(dis[cur.v],e.w);
					q.add(new Edge(e.v, dis[e.v]));
				}
			}
		}
		Edge[] e = new Edge[n+1];
		e[0] = new Edge(0,0);
		for (int i = 1; i <= n; i++) {
			e[i] = new Edge(i,dis[i]);
		}
		Arrays.sort(e);
		long count = 0;
		int lvl = 1;
		long temp = t[1];
		for (int i = 1; i <= n; i++) {
			if (e[i].w == Integer.MAX_VALUE) {
				break;
			}
			count += (e[i].w - lvl) * temp;
			lvl = e[i].w;
			temp = Math.min(temp, t[e[i].v]);
			if (e[i].v == n) {
				System.out.println(count);
				return;
			}
		}
		System.out.println(-1);
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
