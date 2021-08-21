import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = next();
		int[] l = new int[n+2], r = new int[n+2];
		for (int i = 1; i <= n; i++) {
			if (str.charAt(i-1) == 'R') {
				r[i]++;
			}
			r[i] += r[i-1];
		}
		for (int i = n; i >= 1; i--) {
			if (str.charAt(i-1) == 'L') {
				l[i]++;
			}
			l[i] += l[i+1];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			min = Math.min(min, ((i-1) - r[i-1]) + ((n-i) - l[i+1]));
		}
		System.out.println(min);
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
