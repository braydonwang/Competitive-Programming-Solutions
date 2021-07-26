import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Edge> adj[];
	static int far;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int[] count = new int[n+1];
		int sum = 0;
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			adj[a].add(new Edge(b,c));
			adj[b].add(new Edge(a,c));
			count[a]++; count[b]++;
			sum += c;
		}
		int[] dis1 = new int[n+1], dis2 = new int[n+1];
		far = 0;
		dijkstra(1,dis1);
		dijkstra(far,dis1);
		dijkstra(far,dis2);
		for (int i = 1; i <= n; i++) {
			if (count[i] == t) {
				int temp = Math.max(dis1[i], dis2[i]);
				System.out.println(i + " " + ((sum-temp)*2 + temp));
			}
		}
	}
	static void dijkstra(int v, int[] dis) {
		PriorityQueue<Edge> q = new PriorityQueue();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[v] = 0; q.add(new Edge(v,0));
		int max = 0;
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (dis[cur.v] > max) {
				max = dis[cur.v];
				far = cur.v;
			}
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
