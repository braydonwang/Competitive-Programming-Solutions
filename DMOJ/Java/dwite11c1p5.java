import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			String str = next();
			dp = new int[str.length()][str.length()];
			System.out.println(solve(str,0,str.length()-1));
		}
	}
	static int solve(String str, int l, int r) {
		if (dp[l][r] > 0) {
			return dp[l][r];
		}
		if (l == r) {
			return dp[l][r] = 1;
		} else if (l + 1 == r && str.charAt(l) == str.charAt(r)) {
			return dp[l][r] = 2;
		} else if (str.charAt(l) == str.charAt(r)) {
			return dp[l][r] = solve(str,l+1,r-1) + 2;
		} else {
			return dp[l][r] = Math.max(solve(str,l+1,r), solve(str,l,r-1));
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
