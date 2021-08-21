import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		long[] array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = readLong();
		}
		Arrays.sort(array);
		long[] diff = new long[n+2];
		for (int i = 0; i < q; i++) {
			int l = readInt(), r = readInt();
			diff[l]++; diff[r+1]--;
		}
		for (int i = 1; i <= n; i++) {
			diff[i] += diff[i-1];
		}
		Arrays.sort(diff);
		long total = 0;
		for (int i = 2; i <= n+1; i++) {
			total += diff[i] * array[n-i+1];
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
