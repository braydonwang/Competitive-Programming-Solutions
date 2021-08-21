import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		long[][] pre = new long[m+2][n+2];
		for (int i = 0; i < k; i++) {
			int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
			pre[y1][x1]++; pre[y2+1][x1]--; pre[y1][x2+1]--; pre[y2+1][x2+1]++;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				pre[i][j] += pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				pre[i][j] += pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
			}
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int a = readInt(), b = readInt(), c = readInt(), d = readInt();
			System.out.println(pre[d][c] - pre[b-1][c] - pre[d][a-1] + pre[b-1][a-1]);
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
