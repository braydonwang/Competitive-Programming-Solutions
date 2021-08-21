import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = next();
		char[][] a = new char[3005][n];
		for (int i = 0; i < 3005; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = '.';
			}
		}
		int minc = Integer.MAX_VALUE, minr = Integer.MAX_VALUE, maxr = 0, maxc = 0;
		int r = 1005, c = 0;
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch == '^') {
				a[r][c] = '/';
				maxr = Math.max(maxr, r); maxc = Math.max(maxc, c);
				minr = Math.min(minr, r); minc = Math.min(minc, c);
				r = r-1; c = c + 1;
			} else if (ch == 'v') {
				a[r+1][c] = '\\';
				maxr = Math.max(maxr, r+1); maxc = Math.max(maxc, c);
				minr = Math.min(minr, r+1); minc = Math.min(minc, c);
				r = r + 1; c = c + 1;
			} else {
				a[r][c] = '_';
				maxr = Math.max(maxr, r); maxc = Math.max(maxc, c);
				minr = Math.min(minr, r); minc = Math.min(minc, c);
				c = c + 1;
			}
		}
		//System.out.println(minr + " " + maxr);
		for (int i = minr; i <= maxr; i++) {
			boolean good = false;
			for (int j = 0; j < n; j++) {
				if (a[i][j] != '.') {
					good = true;
					break;
				}
			}
			if (good) {
				for (int j = 0; j < n; j++) {
					System.out.print(a[i][j]);
				}
			}
			System.out.println();
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
