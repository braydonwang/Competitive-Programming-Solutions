import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		int n = readInt();
		double[] array = new double[n+1];
		double[][] dp = new double[n+1][n+1];  //[using the first i coins][getting j number of heads]
		for (int i = 1; i <= n; i++) {
			array[i] = readDouble();
		}
		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = (1-array[i])*dp[i-1][j];
				} else {
					dp[i][j] = (array[i]*dp[i-1][j-1]) + ((1-array[i])*dp[i-1][j]);
				}
			}
		}
		double sum = 0;
		for (int i = (n+1)/2; i <= n; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum);
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
