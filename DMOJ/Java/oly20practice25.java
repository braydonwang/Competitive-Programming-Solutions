import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		for (int i = 0; i < k; i++) {
			int s = readInt(), t = readInt(), r = readInt();
			int solved = 0, time = 0;
			while (true) {
				if (solved + s*t >= n) {
					System.out.println((int)Math.ceil((n - solved) / (s*1.0) + time));
					break;
				}
				time += t + r;
				solved += t*s;
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
