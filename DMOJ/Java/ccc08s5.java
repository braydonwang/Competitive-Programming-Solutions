import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][][][] dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			int a = readInt(), b = readInt(), c = readInt(), d = readInt();
			dp = new int[a+1][b+1][c+1][d+1][3];
			if (solve(a,b,c,d,1) == 1) {
				System.out.println("Patrick");
			} else {
				System.out.println("Roland");
			}
		}
	}
	static int solve(int a, int b, int c, int d, int i) {
		if (dp[a][b][c][d][i] != 0) {
			return dp[a][b][c][d][i];
		}
		int temp = 0;
		if (r1(a,b,c,d)) {
			temp = solve(a-2,b-1,c,d-2,3-i);
			if (temp == i) {
				return dp[a][b][c][d][i] = i;
			}
		}
		if (r2(a,b,c,d)) {
			temp = solve(a-1,b-1,c-1,d-1,3-i);
			if (temp == i) {
				return dp[a][b][c][d][i] = i;
			}
		}
		if (r3(a,b,c,d)) {
			temp = solve(a,b,c-2,d-1,3-i);
			if (temp == i) {
				return dp[a][b][c][d][i] = i;
			}
		}
		if (r4(a,b,c,d)) {
			temp = solve(a,b-3,c,d,3-i);
			if (temp == i) {
				return dp[a][b][c][d][i] = i;
			}
		}
		if (r5(a,b,c,d)) {
			temp = solve(a-1,b,c,d-1,3-i);
			if (temp == i) {
				return dp[a][b][c][d][i] = i;
			}
		}
		return dp[a][b][c][d][i] = 3-i;
	}
	static boolean r1(int a, int b, int c, int d) {
		if (a >= 2 && b >= 1 && d >= 2) {
			return true;
		}
		return false;
	}
	static boolean r2(int a, int b, int c, int d) {
		if (a >= 1 && b >= 1 && c >= 1 && d >= 1) {
			return true;
		}
		return false;
	}
	static boolean r3(int a, int b, int c, int d) {
		if (c >= 2 && d >= 1) {
			return true;
		}
		return false;
	}
	static boolean r4(int a, int b, int c, int d) {
		if (b >= 3) {
			return true;
		}
		return false;
	}
	static boolean r5(int a, int b, int c, int d) {
		if (a >= 1 && d >= 1) {
			return true;
		}
		return false;
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
