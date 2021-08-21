import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (gcd(i,j) == 1) {
					list.add(new Pair(i-1,j-1));
				}
			}
		}
		int mod = (int) 1e9;
		int[] dp = new int[1 << n];
		dp[0] = 1;
		for (Pair p: list) {
			for (int mask = (1 << (n-1)) - 1; mask >= 0; mask--) {
				int new_mask = mask | (((1 << p.b) - 1) - ((1 << p.a)- 1));
				//System.out.println(new_mask);
				dp[new_mask] = (dp[new_mask] + dp[mask]) % mod;
			}
		}
		//System.out.println((1 << (n-1))-1);
		System.out.println(dp[(1 << (n-1))-1]);
	}
	static class Pair{
		int a, b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a,a);
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
