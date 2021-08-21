import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] first = new int[n];
		int[] second = new int[m];
		for (int i = 0; i < n; i++) {
			first[i] = readInt();
		}
		for (int i = 0; i < m; i++) {
			second[i] = readInt();
		}
		int[][] array = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (first[i-1] == second[j-1]) {
					array[i][j] = array[i-1][j-1] + 1;
				} else {
					array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
				}
			}
		}
		System.out.println(array[n][m]);
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
