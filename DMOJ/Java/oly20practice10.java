import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int max = (int)1e6+5;
		long[] pre = new long[max];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int m = readInt(), x = readInt();
			pre[x+1] += m;
			sum += m;
		}
		for (int i = 1; i < max; i++) {
			pre[i] += pre[i-1];
		}
		long ans = 0;
		for (int i = 2*k+1; i <= 1e6; i++) {
			ans = Math.max(ans, pre[i] - pre[i-2*k-1]);
		}
		if (2*k >= 1e6) {
			System.out.println(sum);
			return;
		}
		System.out.println(ans);
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
