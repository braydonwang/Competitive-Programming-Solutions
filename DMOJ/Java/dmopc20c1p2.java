import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), d = readInt();
		long[] pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i-1] + readInt();
		}
		int l = 1, r = n;
		for (int i = 0; i < d; i++) {
			int x = readInt();
			x = x + l - 1;
			long sum1 = pre[x] - pre[l-1];
			long sum2 = pre[r] - pre[x];
			//System.out.println(x+l-1 + " " + l + " " + r);
			//System.out.println(sum1 + " " + sum2);
			if (sum1 >= sum2) {
				System.out.println(sum1);
				l = x+1;
			} else {
				System.out.println(sum2);
				r = x;
			}
		}
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
