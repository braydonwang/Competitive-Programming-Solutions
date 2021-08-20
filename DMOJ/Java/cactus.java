import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		double n = readDouble();
		int m = readInt(), k = readInt();
		int max = (int) ((1e5 * 2) + 3);
		int[] t = new int[k];
		double[] a = new double[k];
		long[] array = new long[max];
		for (int i = 0; i < k; i++) {
			t[i] = readInt(); a[i] = readInt() / 100.0;
		}
		for (int i = 0; i < m; i++) {
			int d = readInt(), e = readInt(), f = readInt();
			array[d] += f; array[d+e] -= f;
		}
		for (int i = 0; i < max; i++) {
			if (i != 0) {
				array[i] += array[i-1];
			}
			if (array[i] > 0) {
				double min = Double.MAX_VALUE;
				for (int j = 0; j < k; j++) {
					min = Math.min(min, Math.max(0, (array[i] - t[j]) * (1 - a[j])));
				}
				n -= min;
			}
		}
		if (n < 0) {
			System.out.println("Act Like A Cactus.");
		} else {
			System.out.printf("%.2f", n);
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
