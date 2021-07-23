import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		int[] x = new int[n+1], y = new int[n+1];
		for (int i = 1; i <= n; i++) {
			x[i] = readInt(); y[i] = readInt();
		}
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		boolean[] vis = new boolean[n+1];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				Queue<Integer> q = new LinkedList();
				q.add(i); vis[i] = true;
				int a = Integer.MAX_VALUE, b = 0, c = Integer.MAX_VALUE, d = 0;
				while (!q.isEmpty()) {
					int cur = q.poll();
					a = Math.min(a, x[cur]);
					b = Math.max(b, x[cur]);
					c = Math.min(c, y[cur]);
					d = Math.max(d, y[cur]);
					for (int nxt: adj[cur]) {
						if (!vis[nxt]) {
							q.add(nxt); vis[nxt] = true;
						}
					}
				}
				min = Math.min(min, 2*(b-a+d-c));
			}
		}
		System.out.println(min);
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
