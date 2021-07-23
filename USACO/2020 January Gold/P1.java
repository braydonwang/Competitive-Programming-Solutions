import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int c;
	static int[] m;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt(); c = readInt();
		m = new int[n+1]; dp = new int[n+1][1001]; 
		for (int i = 1; i <= n; i++) {
			m[i] = readInt();
		}
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < t; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b);
		}
		Queue<Integer> q = new LinkedList();
		q.add(1); q.add(0); dp[1][0] = 0;
		while (!q.isEmpty()) {
			int v = q.poll(), dis = q.poll();
			for (int nxt: adj[v]) {
				if(dp[nxt][dis+1] < m[nxt] + dp[v][dis] - ((dis+1)*(dis+1)*c - dis*dis*c)) {
					dp[nxt][dis+1] = m[nxt] + dp[v][dis] - ((dis+1)*(dis+1)*c - dis*dis*c);
					q.add(nxt); q.add(dis+1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= 1000; i++) {
			max = Math.max(max, dp[1][i]);
		}
		System.out.println(max);
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
