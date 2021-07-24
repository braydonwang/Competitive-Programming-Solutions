import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a, b, w, p;
	static int[] array;
	static int n, m;
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt();
		p = new int[n+1]; a = new int[m]; b = new int[m]; w = new int[m];
		int lo = 0, hi = 0, max = 0;
		for (int i = 1; i <= n; i++) {
			p[i] = readInt();
		}
		for (int i = 0; i < m; i++) {
			a[i] = readInt(); b[i] = readInt(); w[i] = readInt();
			max = Math.max(max, w[i]);
		}
		int ans = 0; hi = max + 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (check(mid)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		if (ans == max+1) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	static boolean check(int mid) {
		array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}
		for (int i = 0; i < m; i++) {
			if (w[i] >= mid) {
				union(a[i],b[i]);
			}
		}
		for (int i = 1; i <= n; i++) {
			if (find(p[i]) != find(i)) {
				return false;
			}
		}
		return true;
	}
	public static int find(int v) {
		if (array[v] == v) {
			return v;
		}
		else {
			int result = find(array[v]);
			array[v] = result;
			return result;
		}
	}
	public static void union(int a, int b) {
		int arep = find(a);
		int brep = find(b);
		array[arep] = brep;
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
