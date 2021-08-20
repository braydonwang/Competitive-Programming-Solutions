import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt(), c = readInt();
		int[] dif = new int[a+2];
		for (int i = 0; i < c; i++) {
			int d = readInt(), e = readInt(), f = readInt();
			dif[d] += f; dif[e+1] -= f;
		}
		int count = 0;
		for (int i = 1; i <= a; i++) {
			dif[i] += dif[i-1];
			if (dif[i] < b) {
				count++;
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
