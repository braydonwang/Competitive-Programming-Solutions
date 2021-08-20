import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		Queue<Integer> q = new LinkedList();
		int[] dis = new int[n+1], dis2 = new int[n+1];
		boolean[] vis = new boolean[n+1], vis2 = new boolean[n+1];
		q.add(1); vis[1] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				if (!vis[nxt]) {
					q.add(nxt); vis[nxt] = true; dis[nxt] = dis[cur] + 1;
				}
			}
		}
		q.add(n); vis2[n] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				if (!vis2[nxt]) {
					q.add(nxt); vis2[nxt] = true; dis2[nxt] = dis2[cur] + 1;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (vis[i] && vis2[i] && dis[i] <= k && dis2[i] <= k) {
				count++;
			}
		}
		System.out.println(power(2,count));
	}
	static long power(long x, long y) {
		long ans = 1, mod = (long) (1e9+7);
		while (y > 0) {
			if (y % 2 != 0) {
				ans = multiply(ans,x,mod);
			}
			x = multiply(x,x,mod);
			y = y/2;
		}
		return ans;
	}
	static long multiply(long a, long b, long k) {
		return ((a % k) * (b % k)) % k;
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
