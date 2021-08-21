import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long m = readLong();
		long[] pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i-1] + readLong();
		}
		int l = 1, r = 1, min = Integer.MAX_VALUE;
		while (l <= r && r <= n) {
			long sum = pre[r] - pre[l-1];
			if (sum < m) {
				r++;
			} else {
				min = Math.min(r - l + 1, min);
				l++;
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
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
