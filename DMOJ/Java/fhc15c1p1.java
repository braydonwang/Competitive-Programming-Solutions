import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		int max = 10000005;
		int[] prime = new int[max];
		for (int i = 2; i < max; i++) {
			if (prime[i] == 0) {
				for (int j = 1; j*i < max; j++) {
					prime[i*j]++;
				}
			}
		}
		for (int q = 1; q <= t; q++) {
			int a = readInt(), b = readInt(), k = readInt();
			int count = 0;
			for (int i = a; i <= b; i++) {
				if (prime[i] == k) {
					count++;
				}
			}
			System.out.println("Case #" + q + ": " + count);
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
