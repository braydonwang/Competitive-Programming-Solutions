import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		Arrays.sort(array);
		int left = array[0]; int right = array[n-1];
		int ans = -1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (works(mid, array, n, k)) {
				left = mid+1;
				ans = Math.max(ans, mid);
			}
			else {
				right = mid;
			}
		}
		System.out.println(ans);
	}
	static boolean works(int mid, int[] array, int n, int k) {
		int count = 1;
		int pos = array[0];
		for (int i = 1; i < n; i++) {
			if (array[i] - pos >= mid) {
				pos = array[i];
				count++;
			}
		}
		if (count >= k) {
			return true;
		}
		return false;
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
