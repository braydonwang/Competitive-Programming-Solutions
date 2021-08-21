import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n+1];
		long[] pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
			pre[i] = array[i] + pre[i-1];
		}
		long sum = 0;
		int l = 1, r = n;
		for (int i = 0; i < n; i++) {
			sum += pre[r] - pre[l-1];
			l++; r--;
			System.out.println(sum);
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
