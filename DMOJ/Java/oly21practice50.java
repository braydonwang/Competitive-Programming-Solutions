import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n+1];
		int[] freq = new int[(int)1e6+5];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
			freq[a[i]]++;
		}
		int[] ans = new int[n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= Math.sqrt(a[i]); j++) {
				if (a[i] % j == 0) {
					int k = a[i] / j;
					if (j == k) {
						ans[i] += freq[j];
					} else {
						ans[i] += freq[j] + freq[k];
					}
					if (k == a[i]) {
						ans[i]--;
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(ans[i]);
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
