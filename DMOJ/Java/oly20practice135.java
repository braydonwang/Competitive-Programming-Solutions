import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int x = readInt(), y = readInt();
			int temp = a[x];
			a[x] = a[y]; a[y] = temp;
		}
		long ans = 1;
		boolean[] vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if (vis[i]) {
				continue;
			}
			long cnt = 1, cur = i;
			while (true) {
				cur = a[(int)cur];
				if (cur == i) {
					vis[(int)cur] = true;
					break;
				}
				if (vis[(int)cur]) {
					System.out.println(-1);
					return;
				}
				vis[(int)cur] = true;
				cnt++;
			}
			ans = ans*cnt / gcd(ans,cnt);
		}
		System.out.println(ans);
	}
	static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
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
