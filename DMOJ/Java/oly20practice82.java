import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] array;
	public static void main(String[] args) throws IOException {
		n = readInt(); int q = readInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		Arrays.sort(array);
		for (int i = 0; i < q; i++) {
			int l = readInt(), r = readInt();
			System.out.println(upper(r) - lower(l) + 1);
		}
	}
	static int lower(int x) {
		int l = 0, r = n-1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (array[mid] >= x) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	static int upper(int x) {
		int l = 0, r = n-1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (array[mid] <= x) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return r;
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
