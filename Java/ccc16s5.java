import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		long t = readLong();
		int[] array = new int[n];
		String str = next();
		for (int i = 0; i < n; i++) {
			array[i] = str.charAt(i) - '0';
		}
		for (int i = 63; i >= 0; i--) {
			if (((t >> i) & 1) == 1) {
				array = solve(i,array);
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(array[i]);
		}
	}
	static int[] solve(int num, int[] array) {
		int[] newArray = new int[n];
		for (long i = 0; i < n; i++) {
			int t1 = (int) (((i - ((long)(1L << num))%n) + n) % n);
			int t2 = (int) ((i + ((long)(1L << num))%n) % n);
			if (t1 < 0) {
				int mod = (int) Math.ceil(-t1 / (n*1.0));
				t1 += n*mod;
			}
			/*if (t2 < 0) {
				int mod = (int) Math.ceil(-t2 / (n*1.0));
				t2 += n*mod;
			}*/
			newArray[(int)i] = array[t1] ^ array[t2];
		}
		return newArray;
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
