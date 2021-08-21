import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = next();
		int[][] pre = new int[n+2][26], suf = new int[n+2][26];
		for (int i = 1; i <= n; i++) {
			int ch = str.charAt(i-1) - 'a';
			pre[i][ch]++;
			for (int j = 0; j < 26; j++) {
				pre[i][j] += pre[i-1][j];
			}
		}
		for (int i = n; i >= 1; i--) {
			int ch = str.charAt(i-1) - 'a';
			suf[i][ch]++;
			for (int j = 0; j < 26; j++) {
				suf[i][j] += suf[i+1][j];
			}
		}
		int max = 0;
		for (int i = 2; i < n; i++) {
			int count = 0;
			for (int j = 0; j < 26; j++) {
				if (pre[i-1][j] > 0 && suf[i][j] > 0) {
					count++;
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
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
