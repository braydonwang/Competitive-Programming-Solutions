import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int k = readInt(), c = readInt();
		int sum = 0;
		for (int i = 0; i < k; i++) {
			int[] array = new int[c];
			for (int j = 0; j < c; j++) {
				array[j] = readInt();
			}
			int[][] dp = new int[c][c];
			int max = 0;
			for (int l = c-1; l >= 0; l--) {
				for (int r = l; r < c; r++) {
					if (l == r) {
						dp[l][r] = array[r] * c;
					} else {
						dp[l][r] = Math.max(dp[l+1][r] + (array[l] * (c-(r-l+1)+1)), dp[l][r-1] + (array[r] * (c-(r-l+1)+1)));
					}
					max = Math.max(max, dp[l][r]);
				}
			}
			sum += max;
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
