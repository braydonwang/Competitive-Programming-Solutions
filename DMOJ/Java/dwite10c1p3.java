import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			int n = readInt(), m = readInt();
			System.out.println(solve(n,m,8192));
		}
	}
	static int solve(int n, int m, int max) {
		int temp = Math.min(n, m);
		for (int i = max; i >= 1; i /= 2) {
			if (temp >= i) {
				//System.out.println(i);
				return 1 + solve(n-i,m,i) + solve(i,m-i,i);
			}
		}
		return 0;
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
