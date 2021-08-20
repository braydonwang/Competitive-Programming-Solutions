import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[] max = new int[n];
		int[] min = new int[n];
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		max[n-1] = array[n-1]; min[n-1] = array[n-1];
		for (int i = n-2; i >= 0; i--) {
			max[i] = Math.max(max[i+1], array[i]);
			min[i] = Math.min(min[i+1], array[i]);
		}
		//System.out.println(Arrays.toString(max));
		//System.out.println(Arrays.toString(min));
		for (int i = 0; i < q; i++) {
			int g = readInt(), e = readInt();
			int l = 0, r = n-1, ans = 0;
			while (l <= r) {
				int mid = (l + r) / 2;
				if (max[mid] <= g+e && min[mid] >= g-e) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			//System.out.println(l + " " + r);
			System.out.println(n-l);
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
