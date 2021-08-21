import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int d = readInt(), n = readInt(), r = readInt();
		String a = next(), b = next();
		int[][] dp = new int[a.length()+1][b.length()+1];
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 && j != 0) {
					dp[i][j] = j * n;
				} else if (i != 0 && j == 0) {
					dp[i][j] = i * d;
				}
				if (i != 0 && j != 0) {
					if (a.charAt(i-1) == b.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1];
					} else {
						dp[i][j] = Math.min(dp[i-1][j-1]+r, Math.min(dp[i-1][j]+d, dp[i][j-1]+n));
					}
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);
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
