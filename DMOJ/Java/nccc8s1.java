import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String a = next();
		String str = next();
		int n = str.length(), m = a.length();
		TreeSet<String> set = new TreeSet();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				set.add(str.substring(0,i) + a.charAt(j) + str.substring(i));
			}
		}
		for (int i = 0; i < n; i++) {
			set.add(str.substring(0,i) + str.substring(i+1));
			for (int j = 0; j < m; j++) {
				set.add(str.substring(0,i) + a.charAt(j) + str.substring(i+1));
			}
		}
		for (String s: set) {
			if (!s.equals(str)) {
				System.out.println(s);
			}
		}
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
