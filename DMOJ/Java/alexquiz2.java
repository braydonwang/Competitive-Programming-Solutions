import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int q = readInt();
		int max = (int) (1e5);
		long[] pre = new long[max+1];
		for (int i = 2; i <= max; i++) {
			if (isPrime(i)) {
				pre[i] = i;
			}
			pre[i] += pre[i-1];
		}
		for (int i = 0; i < q; i++) {
			int a = readInt(), b = readInt();
			System.out.println(pre[b] - pre[a-1]);
		}
	}
	static boolean isPrime(int x) {
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
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
