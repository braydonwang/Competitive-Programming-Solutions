import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		int[] pre = new int[n+1];
		int ind = 1, count = 1;
		for (int i = 2; i <= n; i++) {
			if (a[i] != a[i-1]) {
				count++;
			} else {
				pre[ind] = count; ind++;
				count = 1;
			}
		}
		pre[ind] = count; ind++;
		for (int i = 1; i < ind; i++) {
			pre[i] += pre[i-1];
		}
		if (ind <= 4) {
			System.out.println(pre[ind-1]);
		} else {
			int max = 0;
			for (int i = 3; i < ind; i++) {
				max = Math.max(max, pre[i]-pre[i-3]);
			}
			System.out.println(max);
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
