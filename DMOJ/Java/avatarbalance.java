import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), ind = 1;
		int sz = (int)Math.pow(2, n);
		int[] array = new int[sz];
		for (int i = 0; i < n; i++) {
			int x = readInt();
			for (int j = 0; j < ind; j++) {
				array[j+ind] = array[j] + x;
			}
			ind *= 2;
		}
		int sum = array[sz-1];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < sz; i++) {
			if (Math.abs(array[i]-(sum-array[i])) < min) {
				min = Math.abs(array[i]-(sum-array[i]));
			}
		}
		System.out.println(min);
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
