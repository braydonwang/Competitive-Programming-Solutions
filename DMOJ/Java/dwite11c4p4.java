import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dp;
	static int n;
	static int[] array;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 3; b++) {
				n = readInt();
				array = new int[n];
				for (int i = 0; i < n; i++) {
					array[i] = readInt();
				}
				dp = new int[1 << n];
				int num = solve((1 << n) - 1, 1);
				if (num == 1) {
					System.out.print("A");
				} else {
					System.out.print("B");
				}
			}
			System.out.println();
		}
	}
	static int solve(int mask, int p) {
	    if (dp[mask] > 0){
	        return dp[mask];
	    }
		boolean increase = true, decrease = true;
		int prev = -1;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) != 0) {
				if (prev != -1) {
					if (array[i] > prev) {
						decrease = false;
					} else if (array[i] < prev) {
						increase = false;
					}
				}
				prev = array[i];
			}
		}
		if (increase || decrease) {
			return dp[mask] = 3-p;
		}
		boolean win = false;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) != 0) {
				if (solve(mask - (1 << i),3-p) == p) {
					win = true;
					break;
				}
			}
		}
		if (win) {
			return dp[mask] = p;
		} else {
			return dp[mask] = 3-p;
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
