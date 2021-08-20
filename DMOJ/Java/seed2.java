import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		long lo = 1, hi = (long)2e9;
		while (lo <= hi) {
			long mid = (lo + hi) / 2;
			System.out.println(mid);
			System.out.flush();
			String str = next();
			if (str.equals("SINKS")) {
				lo = mid + 1;
			} else if (str.equals("FLOATS")) {
				hi = mid - 1;
			} else {
				return;
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
