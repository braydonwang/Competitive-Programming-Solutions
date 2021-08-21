import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static double[] dp;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		int temp = (int)Math.pow(2, n)-1;
		dp = new double[temp+1];
		double[][] array = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = readInt() / 100.0;
			}
		}
		System.out.println(solve(array,n-1,temp)*100);
	}
	static double solve(double[][] array, int i, int j) {
		//System.out.println(i + " " + j);
		if (j == 0) {
			return 1;
		}
		if (dp[j] > 0.0) {
			return dp[j];
		}
		for (int r = 0; r < n; r++) {
			if (((j & (1 << r)) >> r) == 1) {
				dp[j] = Math.max(dp[j], solve(array,i-1,j - (1 << r)) * array[i][r]);
			}
		}
		return dp[j];
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
