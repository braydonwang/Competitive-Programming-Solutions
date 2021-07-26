import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] vis;
	static ArrayList<Integer> adj[];
	static int ind = 0;
	static ArrayList<Integer> ans[];
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n+1];
		ans = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
			ans[i] = new ArrayList();
		}
		vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			int x = readInt();
			if (x != i) {
				adj[i].add(x);
			} else {
				vis[i] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				dfs(i,i);
				ind++;
			}
		}
		if (ind <= 1) {
			System.out.println(ind);
			for (int i = 0; i < ind; i++) {
				System.out.print(ans[i].size());
				for (int nxt: ans[i]) {
					System.out.print(" " + nxt);
				}
				System.out.println();
			}
		} else {
			System.out.println(2);
			int count = 0;
			for (int i = 0; i < ind; i++) {
				count += ans[i].size();
			}
			System.out.print(count);
			for (int i = 0; i < ind; i++) {
				for (int nxt: ans[i]) {
					System.out.print(" " + nxt);
				}
			}
			System.out.println();
			System.out.print(ind);
			for (int i = ind-1; i >= 0; i--) {
				System.out.print(" " + ans[i].get(0));
			}
		}
	}
	static void dfs(int v, int start) {
		vis[v] = true; ans[ind].add(v);
		for (int nxt: adj[v]) {
			if (nxt != start) {
				dfs(nxt,start);
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
