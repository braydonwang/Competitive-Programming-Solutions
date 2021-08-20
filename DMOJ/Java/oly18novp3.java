import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] array = new int[n];
		int left = 1; int right = 0;
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			right += array[i];
		}
		int ans = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(mid,array,n,k)) {
				ans = Math.min(ans, mid);
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
	static boolean check(int mid, int[] array, int n, int k) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] > mid) {
				return false;
			}
			sum += array[i];
			if (sum > mid) {
				count++;
				sum = array[i];
			}
		}
		if (count < k) {
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
