import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int b = readInt();
		int[] f = new int[b], e = new int[b], p = new int[b];
		for (int i = 0; i < b; i++) {
			f[i] = readInt(); e[i] = readInt(); p[i] = readInt();
		}
		int n = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		Arrays.sort(array);
		int total = 0;
		for (int i = 0; i < b; i++) {
			int lo = 0, hi = n-1, min = Integer.MAX_VALUE;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (array[mid] >= f[i]) {
					min = Math.min(min, array[mid]);
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			if (min > e[i]) {
				total += p[i];
			}
		}
		System.out.println(total);
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
