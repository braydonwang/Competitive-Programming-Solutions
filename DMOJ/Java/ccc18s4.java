import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<Integer,Long> dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		dp = new HashMap<Integer,Long>();
		dp.put(1,(long)1);
		System.out.println(solve(n));
	}
	static long solve(int n) {
		if (dp.containsKey(n)) {
			return dp.get(n);
		}
		long ans = 0;
		long lmt = (long) Math.sqrt(n);
		for (int i = 2; i <= lmt; i++) {
			ans += solve(n/i);
		}
		long last = lmt;
		for (int i = (int)lmt; i >= 1; i--) {
			ans += (n/i - last) * solve(i);
			last = n/i;
		}
		dp.put(n,ans);
		return ans;
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
