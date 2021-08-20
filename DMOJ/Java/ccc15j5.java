import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][] dp;
	static int n;
	public static void main(String[] args) throws IOException {
		int k = readInt();
		n = readInt(); 
		dp = new int[n][k+1][k+1];
		System.out.println(solve(0,k,1));
	}
	static int solve(int ind, int tot, int pre) {
		if (ind == n-1) {
			return 1;
		}
		if (dp[ind][tot][pre] != 0) {
			return dp[ind][tot][pre];
		}
		for (int i = pre; i <= tot/(n-ind); i++) {
			dp[ind][tot][pre] += solve(ind+1,tot-i,i);
		}
		return dp[ind][tot][pre];
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
