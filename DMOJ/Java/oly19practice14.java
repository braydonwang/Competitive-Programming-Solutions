import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] h = new int[n+1];
		for (int i = 1; i <= n; i++) {
			h[i] = readInt();
		}
		int[] pre = new int[n+2], suf = new int[n+2];
		for (int i = 1; i <= n; i++) {
			pre[i] = Math.max(h[i],pre[i-1]);
		}
		for (int i = n; i >= 1; i--) {
			suf[i] = Math.max(h[i], suf[i+1]);
		}
		long ans = 0;
		for (int i = 2; i < n; i++) {
			ans += Math.max(0, Math.min(pre[i-1], suf[i+1]) - h[i]);
		}
		System.out.println(ans);
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
