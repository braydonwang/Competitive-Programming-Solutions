import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt(), n = readInt();
		boolean[] a = new boolean[(int)1e6+5];
		for (int i = 0; i < n; i++) {
			a[readInt()] = true;
		}
		int count = 0;
		while (true) {
			int b = x-count, c = x+count;
			if (b <= 0 || !a[b]) {
				System.out.println(b);
				return;
			} else if (!a[c]) {
				System.out.println(c);
				return;
			}
			count++;
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
