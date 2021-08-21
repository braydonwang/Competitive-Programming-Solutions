import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, root; static long dis[], max;
	static boolean vis[];
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> weight[];
	public static void main(String[] args) throws IOException {
		n = readInt();
		adj = new ArrayList[n+1];
		weight = new ArrayList[n+1];
		ArrayList<Integer> path = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
			weight[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			adj[a].add(b);
			adj[b].add(a);
			weight[a].add(c);
			weight[b].add(c);
		}
		long second = 0;
		max = 0; BFS(1);
		max = 0; BFS(root);
		for (int i = 1; i <= n; i++) {
			if (i != root) {
				second = Math.max(second, dis[i]);
			}
		}
		max = 0; BFS(root);
		for (int i = 1; i <= n; i++) {
			if (i != root) {
				second = Math.max(second, dis[i]);
			}
		}
		System.out.println(second);
	}
	public static void BFS(int x) {
		Queue<Integer> q = new LinkedList();
		vis = new boolean[n+1];
		dis = new long[n+1];
		q.add(x); vis[x] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (dis[cur] > max) {
				max = dis[cur]; root = cur;
			}
			for (int nxt: adj[cur]) {
				if (!vis[nxt]) {
					q.add(nxt); vis[nxt] = true; dis[nxt] = dis[cur] + weight[cur].get(adj[cur].indexOf(nxt));
				}
			}
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
