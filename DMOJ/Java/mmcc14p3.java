import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] vis;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		int n = readInt(), s = readInt();
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		int[] par = new int[n+1];
		int[] cnt = new int[n];
		int ind = 0;
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		Queue<Integer> q = new LinkedList();
		q.add(1); par[1] = -1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			cnt[ind] = cur; ind++;
			for (int nxt: adj[cur]) {
				if (nxt != par[cur]) {
					q.add(nxt); par[nxt] = cur;
				}
			}
		}
		int lo = 0, hi = n;
		int ans = 0;
		while (lo <= hi) {
			vis = new boolean[n+1];
			int mid = (lo + hi) / 2;
			int total = 0;
			for (int i = n-1; i >= 0; i--) {
				if (!vis[cnt[i]]) {
					total++;
					if (total > s) {
						break;
					}
					vis[cnt[i]] = true;
					int temp = cnt[i];
					for (int j = 0; j < mid; j++) {
						if (par[temp] == -1) {
							break;
						}
						temp = par[temp];
					}
					//System.out.println(temp + " " + mid);
					dfs(temp,-1,mid);
					//System.out.println(Arrays.toString(vis));
				}
			}
			if (total > s) {
				lo = mid + 1;
			} else {
				ans = mid;
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int v, int par, int dis) {
		vis[v] = true;
		if (dis == 0) {
			return;
		}
		for (int nxt: adj[v]) {
			if (nxt != par) {
				dfs(nxt,v,dis-1);
			}
		}
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
