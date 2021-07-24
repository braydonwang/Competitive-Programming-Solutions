import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static long[] dis, cnt;
	static long dia, num;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		dia = 0; num = 0; dis = new long[n+1]; cnt = new long[n+1];
		Arrays.fill(cnt, 1);
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		dfs(1,-1);
		System.out.println(dia+1 + " " + num);
	}
	static void dfs(int cur, int pre) {
		for (int nxt: adj[cur]) {
			if (nxt != pre) {
				dfs(nxt,cur);
				if (dia < dis[cur] + dis[nxt] + 1) {
					dia = dis[cur] + dis[nxt] + 1;
					num = cnt[cur] * cnt[nxt];
				} else if (dia == dis[cur] + dis[nxt] + 1) {
					num += cnt[cur] * cnt[nxt];
				}
				if (dis[cur] < dis[nxt] + 1) {
					dis[cur] = dis[nxt] + 1;
					cnt[cur] = cnt[nxt];
				} else if (dis[cur] == dis[nxt] + 1) {
					cnt[cur] += cnt[nxt];
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
