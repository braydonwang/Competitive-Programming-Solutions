import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] array = new int[n+2][n+2];
		for (int i = 1; i <= n; i++) {
			String str = next();
			for (int j = 1; j <= n; j++) {
				char ch = str.charAt(j-1);
				if (ch == '#') {
					array[i][j] = 1;
				}
			}
		}
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n; j++) {
				if (array[i][j] >= 1) {
					array[i][j] += Math.min(array[i+1][j-1], Math.min(array[i+1][j], array[i+1][j+1]));
				}
			}
		}
		int total = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				total += array[i][j];
			}
		}
		System.out.println(total);
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
