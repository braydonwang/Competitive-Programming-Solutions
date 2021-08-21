import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] c = new int[n+1];
		for (int i = 1; i <= n; i++) {
			c[i] = readInt();
		}
		int[] l = new int[(int)1e6+5], r = new int[(int)1e6+5];
		Arrays.fill(l, Integer.MAX_VALUE); Arrays.fill(r, Integer.MIN_VALUE);
		for (int i = 1; i <= n; i++) {
			l[c[i]] = Math.min(l[c[i]], i);
			r[c[i]] = Math.max(r[c[i]], i);
		}
		int max = 0;
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			if (l[a] != Integer.MAX_VALUE && r[b] != Integer.MIN_VALUE && l[a] <= r[b]){
			    max = Math.max(max, r[b] - l[a] + 1);
			}
		}
		System.out.println(max);
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
