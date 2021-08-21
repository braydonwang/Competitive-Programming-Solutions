import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[] x = new long[(int) (1e5+1)];
		long[] y = new long[(int) (1e5+1)];
		int[] a = new int[n], b = new int[n];
		long total = 0;
		for (int i = 0; i < n; i++) {
			a[i] = readInt(); b[i] = readInt();
			x[a[i]]++; y[b[i]]++;
		}
		for (int i = 0; i < n; i++) {
			if (x[a[i]] > 1 && y[b[i]] > 1) {
				total += (x[a[i]] - 1) * (y[b[i]] - 1);
			}
		}
		System.out.println(total);
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
