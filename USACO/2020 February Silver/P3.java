import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, v[], t[]; static List<Integer> adj[];
	public static void main(String[] args) throws IOException {
		n = readInt(); v = new int[n+1]; t = new int[n+1]; adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			v[i] = readInt();
			adj[i] = new ArrayList();
		}
		for (int i = 1; i < n; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v); adj[v].add(u);
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(t, 0); dfs(i,0);
			if (t[i] == 0 || t[i] == 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int u, int pre) {
		t[u] = v[u];
		for (int nxt: adj[u]) {
			if (nxt != pre) {
				dfs(nxt, u); t[u] = (t[u] + 12 - t[nxt]) % 12;
			}
		}
	}
	static class pt implements Comparable<pt>{
		int x, y;
		pt(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int compareTo(pt a) {
			if (x != a.x) {
				return x - a.x;
			}
			return y-a.y;
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
