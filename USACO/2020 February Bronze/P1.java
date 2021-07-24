import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = readInt(); y[i] = readInt();
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int xc = x[i], yc = y[i];
			int maxX = 0, maxY = 0;
			for (int j = 0; j < n; j++) {
				if (x[j] == xc) {
					maxY = Math.max(maxY, Math.abs(yc-y[j]));
				}
				if (y[j] == yc) {
					maxX = Math.max(maxX, Math.abs(xc-x[j]));
				}
			}
			max = Math.max(max, maxX*maxY);
		}
		System.out.println(max);
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
