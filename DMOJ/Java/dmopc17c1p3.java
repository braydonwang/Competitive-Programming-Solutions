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
			int a = readInt(), b = readInt(), c = readInt();
			adj[a].add(new Edge(b,c)); adj[b].add(new Edge(a,c));
		}
		int[][] dis = new int[n+1][2];
		for (int i = 0; i <= n; i++) {
			dis[i][0] = dis[i][1] = (int)1e9;
		}
		Queue<Integer> q = new LinkedList();
		q.add(1); dis[1][0] = dis[1][1] = 0;
		while (!q.isEmpty()) {
			int v = q.poll();
			for (Edge nxt: adj[v]) {
				if (nxt.w == 0) {
					if (dis[nxt.v][0] > dis[v][0]) {
						dis[nxt.v][0] = dis[v][0];
						dis[nxt.v][1] = dis[v][1] + 1;
						q.add(nxt.v);
					} else if (dis[nxt.v][0] == dis[v][0] && dis[nxt.v][1] > dis[v][1] + 1) {
						dis[nxt.v][1] = dis[v][1] + 1;
						q.add(nxt.v);
					}
				} else {
					if (dis[nxt.v][0] > dis[v][0] + 1) {
						dis[nxt.v][0] = dis[v][0] + 1;
						dis[nxt.v][1] = dis[v][1] + 1;
						q.add(nxt.v);
					} else if (dis[nxt.v][0] == dis[v][0] + 1 && dis[nxt.v][1] > dis[v][1] + 1) {
						dis[nxt.v][1] = dis[v][1] + 1;
						q.add(nxt.v);
					}
				}
			}
		}
		if (dis[n][0] == (int)1e9) {
			System.out.println(-1);
		} else {
			System.out.println(dis[n][0] + " " + dis[n][1]);
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
