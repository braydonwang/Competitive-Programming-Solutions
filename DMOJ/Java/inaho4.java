import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		double[] x = new double[n], y = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = readDouble();
		}
		for (int i = 0; i < n; i++) {
			y[i] = readDouble();
		}
		double ans = 0;
		for (int i = 0; i < n; i++) {
			ans += (x[i]-y[i])*(x[i]-y[i]);
		}
		System.out.println(Math.sqrt(ans));
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
