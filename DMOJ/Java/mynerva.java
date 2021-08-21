import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int x = readInt(), y = readInt(), z = readInt();
			adj[x].add(new Edge(y,z));
			adj[y].add(new Edge(x,z));
		}
		int[] max = new int[n+1], min = new int[n+1], dis = new int[n+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		Arrays.fill(dis, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList();
		q.add(1); dis[1] = 0; min[1] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Edge e: adj[cur]) {
				if (dis[cur] + 1 < dis[e.v]) {
					dis[e.v] = dis[cur] + 1;
					min[e.v] = min[cur] + e.w;
					max[e.v] = max[cur] + e.w; 
					q.add(e.v);
				} else if (dis[cur] + 1 == dis[e.v]) {
					min[e.v] = Math.min(min[e.v] , min[cur] + e.w); 
					max[e.v] = Math.max(max[e.v] , max[cur] + e.w); 
				}
			}
		}
		int t = readInt();
		for (int i = 0; i < t; i++) {
			int x = readInt();
			String str = next();
			if (str.equals("Black")) {
				System.out.println(dis[x] + " " + min[x]);
			} else {
				System.out.println(dis[x] + " " + max[x]);
			}
		}
	}
	static class Edge{
		int v,w;
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
