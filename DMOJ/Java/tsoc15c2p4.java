import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int mod = (int)1e9+7;
	static int[] dis;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList();
		}
		int[] in = new int[n];
		dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b);
			in[b]++;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (in[i] == 0) {
				ans = (ans + dfs(i,-1,1)) % mod;
			}
		}
		System.out.println(ans);
		for (int i = 0; i < n; i++) {
			if (dis[i] != Integer.MAX_VALUE) {
				System.out.print(dis[i] + " ");
			}
		}
		System.out.println();
	}
	static int dfs(int v, int pre, int d) {
		if (adj[v].size() == 0) {
			dis[v] = Math.min(dis[v], d);
			return 1;
		}
		int total = 0;
		for (int nxt: adj[v]) {
			if (nxt != pre) {
				total = (total + dfs(nxt,v,d+1)) % mod;
			}
		}
		return total;
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
