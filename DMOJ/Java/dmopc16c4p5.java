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
			int a = readInt(), b = readInt(), p = readInt();
			adj[a].add(new Edge(b,p));
			adj[b].add(new Edge(a,p));
		}
		Queue<Integer> q = new LinkedList();
		int[] dis = new int[n+1];
		q.add(1);
		dis[1] = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Edge e: adj[cur]) {
				if (dis[e.v] < Math.min(dis[cur], e.w)) {
					dis[e.v] = Math.min(dis[cur], e.w);
					q.add(e.v);
				}
			}
		}
		System.out.println(0);
		for (int i = 2; i <= n; i++) {
			System.out.println(dis[i]);
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
