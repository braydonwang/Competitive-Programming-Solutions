import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dp;
	static long[] hash, pow;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			String str = next();
			int n = str.length();
			hash = new long[n+1]; pow = new long[n+1];
			long base = 131;
			pow[0] = 1;
			for (int i = 1; i <= n; i++) {
				hash[i] = hash[i-1] * base + str.charAt(i-1);
				pow[i] = pow[i-1] * base;
			}
			//System.out.println(Arrays.toString(hash));
			//System.out.println(Arrays.toString(pow));
			dp = new int[n];
			Arrays.fill(dp,-1);
			//System.out.println(str);
			System.out.println(solve(str,0,n-1));
		}
	}
	static int solve(String str, int l, int r) {
		if (dp[l] != -1) {
			return dp[l];
		}
		if (l == r) {
			return 1;
		} else if (l > r) {
			return 0;
		}
		dp[l] = 1;
		for (int i = l, j = r; i < j; i++,j--) {
			long a = getSubstrHash(hash,pow,l-1,i,i-l+1), b = getSubstrHash(hash,pow,j-1,r,r-j+1);
			//System.out.println(str.substring(l,i+1) + " " + str.substring(j,r+1) + " " + a + " " + b);
			if (a == b) {
				//System.out.println(str.substring(l,i+1) + " " + str.substring(j,r+1) + " " + a + " " + b);
				dp[l] = Math.max(dp[l], solve(str,i+1,j-1) + 2);
				break;
			}
		}
		return dp[l];
	}
	static long getSubstrHash(long[] hash, long[] pow, int l, int r, int n) {
		l++; r++;
		return hash[r] - hash[l] * pow[n];
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
