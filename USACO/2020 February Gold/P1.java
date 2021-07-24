import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Edge> adj[];
	static int[] ans;
	static int[] s;
	static int m;
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), c = readInt();
		s = new int[n+1]; int[] in = new int[n+1];
		ans = new int[n+1]; vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			s[i] = readInt();
		}
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < c; i++) {
			int a = readInt(), b = readInt(), x = readInt();
			adj[a].add(new Edge(b,x)); in[b]++;
		}
		Queue<Integer> q = new LinkedList();
		for (int i = 1; i <= n; i++) {
			if (in[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			ans[cur] = Math.max(ans[cur],s[cur]);
			for (Edge e: adj[cur]) {
				ans[e.v] = Math.max(ans[e.v], Math.max(ans[cur] + e.w, s[e.v]));
				in[e.v]--;
				if (in[e.v] == 0) {
					q.add(e.v);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(ans[i]);
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
