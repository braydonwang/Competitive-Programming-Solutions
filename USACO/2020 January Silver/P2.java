import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long n, k, m;
	public static void main(String[] args) throws IOException {
		n = readLong(); k = readLong(); m = readLong();
		long lo = 1, hi = n, ans = 0;
		//binary search for highest x value
		while (lo <= hi) {
			long mid = (lo + hi) / 2;
			if (solve(n,k,mid)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(long left, long days, long mid) {
	    //how much to give
		long x = left / mid;
		//if < m, you will give m for the remaining days
		if (x <= m) {
			if (m * days >= left) {
				return true;
			} 
			return false;
		}
		//the amount you give will only decrease from here on out so if the amount you currently give does not work, it will not work
		if (x * days < left) {
			return false;
		}
		//no more left to give
		if (left <= 0) {
			return true;
		}
		//the bare minimum milk left needed to give the same amount currently
		long right = mid * x;
		//represents the number of days that you will be giving this current amount of milk using the bare minimum that was found
		long end = (left - right) / x + 1;
		//recursion
		return solve(left-x*end,days-end,mid);
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
