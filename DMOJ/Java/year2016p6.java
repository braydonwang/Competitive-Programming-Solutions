import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] al, ar;
	static int[][][] dp;
	static int w;
	public static void main(String[] args) throws IOException {
		int l = readInt(), r = readInt();
		w = readInt();
		al = new int[l];
		for (int i = 0; i < l; i++) {
			al[i] = readInt();
		}
		ar = new int[r];
		for (int i = 0; i < r; i++) {
			ar[i] = readInt();
		}
		dp = new int[1 << l][1 << r][2];
		for (int i = 0; i < (1 << l); i++) {
			for (int j = 0; j < (1 << r); j++) {
				dp[i][j][0] = dp[i][j][1] = -1;
			}
		}
		System.out.println(Math.min(solve((1 << l) - 1,(1 << r)-1,0),solve((1 << l) - 1,(1 << r) - 1,1)));
	}
	static int solve(int maskl, int maskr, int temp) {
		if (maskl == 0 && maskr == 0) {
			return 1;
		}
		if (dp[maskl][maskr][temp] != -1) {
			return dp[maskl][maskr][temp];
		}
		int min = Integer.MAX_VALUE;
		int suml = getSum(maskl,al), sumr = getSum(maskr,ar);
		for (int i = 0; i < al.length; i++) {
			if ((maskl & (1 << i)) != 0 && Math.abs((suml - al[i]) - sumr) <= w) {
				min = Math.min(min, solve(maskl - (1 << i),maskr,0) + temp);
			}
		}
		for (int i = 0; i < ar.length; i++) {
			if ((maskr & (1 << i)) != 0 && Math.abs((sumr - ar[i]) - suml) <= w) {
				min = Math.min(min, solve(maskl,maskr - (1 << i),1) + (1 - temp));
			}
		}
		return dp[maskl][maskr][temp] = min;
	}
	static int getSum(int mask, int[] array) {
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			if ((mask & (1 << i)) != 0) {
				total += array[i];
			}
		}
		return total;
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
