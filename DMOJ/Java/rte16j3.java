import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			int n = readInt(), c = readInt();
			long[] array = new long[n+1];
			boolean[] cov = new boolean[n+1];
			for (int i = 0; i < c; i++) {
				String str = next();
				if (str.equals("A")) {
					int v = readInt(), x = readInt();
					if (!cov[x]) {
						array[x] += v;
					}
				} else if (str.equals("Q")) {
					int x = readInt();
					System.out.println(array[x]);
				} else if (str.equals("G")) {
					int x = readInt();
					long total = 0;
					for (int j = 1; j <= x; j++) {
						total += array[j];
					}
					System.out.println(total);
				} else if (str.equals("L")) {
					int x = readInt();
					long total = 0;
					for (int j = n-x+1; j <= n; j++) {
						total += array[j];
					}
					System.out.println(total);
				} else {
					int x = readInt();
					cov[x] = true;
					array[x] = 0;
				}
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
