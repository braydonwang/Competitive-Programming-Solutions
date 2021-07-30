import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		String str = next();
		int[][] pre = new int[6][n+1];
		char[][] a = new char[6][3];
		a[0][0] = 'a'; a[0][1] = 'b'; a[0][2] = 'c';
		a[1][0] = 'a'; a[1][1] = 'c'; a[1][2] = 'b';
		a[2][0] = 'b'; a[2][1] = 'a'; a[2][2] = 'c';
		a[3][0] = 'b'; a[3][1] = 'c'; a[3][2] = 'a';
		a[4][0] = 'c'; a[4][1] = 'b'; a[4][2] = 'a';
		a[5][0] = 'c'; a[5][1] = 'a'; a[5][2] = 'b';
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j <= n; j++) {
				pre[i][j] = pre[i][j-1];
				if (a[i][(j-1)%3] != str.charAt(j-1)) {
					pre[i][j]++;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			int l = readInt(), r = readInt();
			int ans = Integer.MAX_VALUE;
			for (int j = 0; j < 6; j++) {
				ans = Math.min(ans, pre[j][r] - pre[j][l-1]);
			}
			System.out.println(ans);
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
