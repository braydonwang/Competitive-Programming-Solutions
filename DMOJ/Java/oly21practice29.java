import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int n = readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = readInt();
			}
			Arrays.sort(a);
			boolean[] vis = new boolean[25001];
			vis[0] = true;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (!vis[a[i]]) {
					count++;
					for (int j = a[i]; j <= 25000; j++) {
						if (vis[j-a[i]]) {
							vis[j] = true;
						}
					}
				}
			}
			System.out.println(count);
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
