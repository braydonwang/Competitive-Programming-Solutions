import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int far;
	static int n;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		//find the eccentricity of each vertex using the diameter
		n = readInt();
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		int[] dis1 = new int[n+1];
		int[] dis2 = new int[n+1];
		far = 0;
		bfs(1,dis1);
		bfs(far,dis1);
		bfs(far,dis2);
		for (int i = 1; i <= n; i++) {
			System.out.println(Math.max(dis1[i], dis2[i]));
		}
	}
	static void bfs(int v, int[] dis) {
		int max = 0;
		Queue<Integer> q = new LinkedList();
		boolean[] vis = new boolean[n+1];
		q.add(v); vis[v] = true; dis[v] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (dis[cur] > max) {
				max = dis[cur];
				far = cur;
			}
			for (int nxt: adj[cur]) {
				if (!vis[nxt]) {
					q.add(nxt); vis[nxt] = true; dis[nxt] = dis[cur] + 1;
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
