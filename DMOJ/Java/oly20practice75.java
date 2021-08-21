import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] array = new int[n+2];
		int[] pre = new int[n+1];
		for (int i = 0; i < m; i++) {
			int l = readInt(), r = readInt();
			array[l]++; array[r+1]--;
		}
		pre[0] = array[0];
		int count = 0;
		for (int i = 1; i <= n; i++) {
			pre[i] = array[i] + pre[i-1];
			if (pre[i] % 2 != 0) {
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
