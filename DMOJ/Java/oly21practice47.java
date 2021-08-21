import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String a = next(), b = next();
		int m = a.length(), n = b.length();
		if (m - n != 1 && m - n != 0) {
			System.out.println("No");
			return;
		}
		int ind = 0, count = 0;
		for (int i = 0; i < m; i++) {
			if (ind >= n) {
				break;
			}
			if (a.charAt(i) == b.charAt(ind)) {
				ind++;
				continue;
			}
			count++;
			if (count > 1) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
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
