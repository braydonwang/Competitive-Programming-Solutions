import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String min;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n-1];
		for (int i = 0; i < n-1; i++) {
			array[i] = readInt();
		} 
		for (int i = 1; i <= n; i++) {
			int[] ans = new int[n];
			int[] used = new int[n+1];
			boolean bad = false;
			ans[0] = i; used[ans[0]] = 1;
			for (int j = 1; j < n; j++) {
				ans[j] = array[j-1] - ans[j-1];
				if (ans[j] > n || ans[j] < 1 || used[ans[j]] == 1) {
					bad = true;
					break;
				} else {
					used[ans[j]] = 1;
				}
			}
			for (int j = 1; j <= n; j++) {
				if (used[j] == 0) {
					bad = true;
					break;
				}
			}
			if (!bad) {
				for (int j = 0; j < n; j++) {
					System.out.print(ans[j] + " ");
				}
			}
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
