import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		long[] diff = new long[t+2], diff2 = new long[t+2], diff3 = new long[t+2];
		for (int i = 0; i < n; i++) {
			int l = readInt(), r = readInt();
			long a = readLong(), b = readLong(), c = readLong();
			long x = r - l;
			diff[l] += c; diff[r+1] -= a*x*x + b*x + c;
			if (x >= 1) {
				diff2[l+1] += a + b; diff2[r+1] -= x*x*a - (x-1)*(x-1)*a + b;
			}
			if (x >= 2) {
				long val = (3*a + b) - (a + b);
				diff3[l+2] += val; diff3[r+1] -= val;
			}
		}
		for (int i = 1; i <= t; i++) {
			diff3[i] += diff3[i-1];
		}
		for (int i = 1; i <= t; i++) {
			diff2[i] += diff2[i-1] + diff3[i];
		}
		for (int i = 1; i <= t; i++) {
			diff[i] += diff[i-1] + diff2[i];
			System.out.print(diff[i] + " ");
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
