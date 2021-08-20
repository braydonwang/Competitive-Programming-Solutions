import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a1, a2;
	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt(), s = readInt();
		long sum = 0;
		for (int i = 0; i < m; i++) {
			String str = next();
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) == 'X') {
					int a = Math.max(0, j-s+1);
					int b = Math.min(n-s, j);
					int c = Math.max(0, i-s+1);
					int d = Math.min(m-s, i);
					sum += (b - a + 1) * (d - c + 1);
					//System.out.println(sum);
				}
			}
		}
		double temp = (m - s + 1) * (n - s + 1);
		System.out.println(sum/temp);
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
