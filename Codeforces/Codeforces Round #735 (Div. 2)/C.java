import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int n = readInt(), m = readInt();
			int p = m+1;
			int ans = 0;
			for (int i = 31; i >= 0; i--) {
				if ((n >> i & 1) == (p >> i & 1)) {
					continue;
				}
				if ((n >> i & 1) == 1 && (p >> i & 1) == 0) {
					break;
				}
				if ((n >> i & 1) == 0 && (p >> i & 1) == 1) {
					ans |= 1 << i;
				}
			}
			System.out.println(ans);
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
