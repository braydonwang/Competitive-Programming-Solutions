import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dp;
	static int n, m, r;
	static Edge[] e;
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt(); r = readInt();
		e = new Edge[m];
		for (int i = 0; i < m; i++) {
			e[i] = new Edge(readInt(),readInt(),readInt());
		}
		Arrays.sort(e);
		dp = new int[m];
		System.out.println(solve(0,0));
	}
	static int solve(int ind, int time) {
		if (ind == m || time >= n) {
			return 0;
		}
		if (dp[ind] != 0) {
			return dp[ind];
		}
		for (int i = ind; i < m; i++) {
			if (e[i].s >= time) {
				dp[ind] = Math.max(dp[ind], e[i].v + solve(i+1,e[i].e+r));
			}
		}
		return dp[ind];
	}
	static class Edge implements Comparable<Edge>{
		int s, e, v;
		Edge(int s, int e, int v){
			this.s = s;
			this.e = e;
			this.v = v;
		}
		public int compareTo(Edge e) {
			return this.s - e.s;
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
