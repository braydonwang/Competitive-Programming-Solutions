import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = next();
		int n = str.length();
		int[][] pre = new int[n+1][2];
		int q = readInt();
		for (int i = 1; i <= n; i++) {
			if (str.charAt(i-1) == '0') {
				pre[i][0]++;
			} else {
				pre[i][1]++;
			}
			pre[i][0] += pre[i-1][0];
			pre[i][1] += pre[i-1][1];
		}
		for (int i = 0; i < q; i++) {
			int x = readInt(), y = readInt(), z = readInt();
			int lo = x, hi = n, ans = -1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (pre[mid][z] >= y + pre[x-1][z]) {
					ans = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			System.out.println(ans);
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
