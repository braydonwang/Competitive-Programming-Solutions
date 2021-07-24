import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = next();
		int lo = 1, hi = n;
		int ans = Integer.MAX_VALUE;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i <= n-mid; i++) {
				set.add(str.substring(i,i+mid));
			}
			if (set.size() == n + 1 - mid) {
				ans = Math.min(mid, ans);
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
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
