import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] a = new int[n+1];
		int count = 0;
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
			if (a[i] == 1) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println(0);
			return;
		}
		for (int i = 1; i <= m; i++) {
			int b = readInt();
			if (a[b] == 0) {
				a[b] = 1;
				count++;
			} else {
				a[b] = 0;
				count--;
			}
			if (count <= i) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(count);
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
