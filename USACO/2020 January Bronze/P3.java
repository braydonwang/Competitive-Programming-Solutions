import java.util.*;
import java.io.*;
public class CCC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long k;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		k = readLong();
		long n = readLong();
		for (int i = 0; i < n; i++) {
			long x = readLong();
			long lo = 0, hi = k, t1 = 0, t2 = 0, mid = 0;
			long ans = 0;
			long d = (1+x)*x/2;
			if (d >= k) {
				while (lo <= hi) {
					mid = (lo + hi)/2;
					if (check1(mid)) {
						ans = mid;
						hi = mid - 1;
					} else {
						lo = mid + 1;
					}
				}
				System.out.println(ans);
				continue;
			}
			lo = 1; hi = k;
			while (lo <= hi) {
				mid = (lo + hi) / 2;
				if (check2(mid,x)) {
					t1 = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			lo = 1; hi = k;
			while (lo <= hi) {
				mid = (lo + hi) / 2;
				if (check3(mid,x)) {
					t2 = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			System.out.println(Math.min(2*t1 - x, 2*t2 - x + 1));
		}
	}
	static boolean check1(long t) {
		return (long)(1+t)*t/2 >= k;
	}
	static boolean check2(long t, long x) {
		return (long)(1+t)*t/2 + (long)(x + t - 1)*(t-x)/2 >= k;
	}
	static boolean check3(long t, long x) {
		return (long)(1+t)*t/2 + (long)(x + t)*(t-x+1)/2 >= k;
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
