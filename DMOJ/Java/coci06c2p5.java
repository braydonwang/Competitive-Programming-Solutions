import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		int[][] pre = new int[r][c+1];
		for (int i = 0; i < r; i++) {
			String str = next();
			for (int j = 1; j <= c; j++) {
				if (str.charAt(j-1) == 'X') {
					pre[i][j]++;
				}
				pre[i][j] += pre[i][j-1];
			}
		}
		int max = 0, row = 0;
		for (int a = 1; a <= c; a++) {
			for (int b = a; b <= c; b++) {
				for (int i = 0; i < r; i++) {
					if (pre[i][b] - pre[i][a-1] == 0) {
						max = Math.max(max, (i - row + 1) * 2 + (b - a + 1) * 2);
					} else {
						row = i+1;
					}
				}
			}
			row = 0;
		}
		System.out.println(max-1);
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
