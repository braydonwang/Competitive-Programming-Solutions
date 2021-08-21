import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] tree, num;
	static int n, maxn;
	public static void main(String[] args) throws IOException {
		n = readInt(); int m = readInt();
		maxn = (int)(1e5+5);
		int[] array = new int[n+1];
		tree = new long[n+1]; num = new long[maxn];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
			update(i,array[i]);
			update2(array[i],1);
		}
		for (int i = 0; i < m; i++) {
			char ch = readCharacter();
			if (ch == 'C') {
				int x = readInt(), v = readInt();
				int dif = v - array[x];
				update(x,dif);
				update2(v,1);
				update2(array[x],-1);
				array[x] = v;
			} else if (ch == 'S') {
				int l = readInt(), r = readInt();
				System.out.println(query(r) - query(l-1));
			} else {
				int v = readInt();
				System.out.println(query2(v));
			}
		}
	}
	static void update2(int x, int v) {
		for (; x < maxn; x += x & -x) {
			num[x] += v;
		}
	}
	static void update(int x, int v) {
		for (; x <= n; x += x & -x) {
			tree[x] += v;
		}
	}
	static long query(int x) {
		long sum = 0;
		for (; x > 0; x -= x & -x) {
			sum += tree[x];
		}
		return sum;
	}
	static long query2(int x) {
		long sum = 0;
		for (; x > 0; x -= x & -x) {
			sum += num[x];
		}
		return sum;
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
