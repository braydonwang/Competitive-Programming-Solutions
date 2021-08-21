import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] bit;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		bit = new int[n*2+1];
		int[] array = new int[n+1];
		int[] pre = new int[n+2];
		int[] suf = new int[n+2];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		for (int i = 1; i <= n; i++) {
			if (array[i] == 1) {
				pre[i] = pre[i-1] + 1;
			} else {
				pre[i] = pre[i-1] - 1;
			}
		}
		for (int i = n; i >= 1; i--) {
			if (array[i] == 1) {
				suf[i] = suf[i+1] + 1;
			} else {
				suf[i] = suf[i+1] - 1;
			}
		}
		for (int i = 1; i <= n+1; i++) {
			update(pre[n] - pre[i-1],1);
		}
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			update(pre[n]-pre[i-1],-1);
			ans += query(pre[n]-pre[i-1]-1);
			//System.out.println(ans);
		}
		System.out.println(ans);
	}
	static void update(int x, int v) {
		x += n;
		for (int i = x; i <= n*2; i += i&-i) {
			bit[i] += v;
		}
	}
	static int query(int x) {
		int total = 0;
		x += n;
		for (int i = x; i > 0; i -= i&-i) {
			total += bit[i];
		}
		return total;
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
