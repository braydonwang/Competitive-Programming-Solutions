import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] a;
	static int[] pre;
	static int[][][] dp = new int[21][2005][2005];
	public static void main(String[] args) throws IOException {
		n = readInt();
		a = new int[n+1];
		pre = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
			pre[i] = a[i] + pre[i-1];
		}
		System.out.println(Math.min(solve(1,a[1],0),Math.min(solve(1,0,a[1]), solve(1,0,0))));
	}
	static int solve(int ind, int b, int c) {
		if (ind == n) {
			return Math.max(b, Math.max(c, pre[n]-c-b));
		}
		if (dp[ind][b][c] != 0) {
			return dp[ind][b][c];
		}
		return dp[ind][b][c] = Math.min(solve(ind+1,b+a[ind+1],c), Math.min(solve(ind+1,b,c+a[ind+1]), solve(ind+1,b,c)));
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
