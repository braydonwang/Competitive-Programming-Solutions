import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long sum = 0;
		long[] array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			sum += n*array[i];
		}
		Arrays.sort(array);
		long[] pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i-1] + array[i-1];
		}
		int[] cnt = new int[n];
		for (int i = 0; i < n; i++) {
			//System.out.println(sum);
			long x = readInt();
			int lo = 0, hi = n-1;
			int ans = -1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (array[mid] > x) {
					ans = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			if (ans != -1) {
				cnt[ans]++;
				sum -= pre[n] - pre[ans];
				sum += (n - ans) * x;
			}
			if (x > array[n-1]) {
				System.out.println(-1);
				return;
			}
		}
		for (int i = 1; i < n; i++) {
			cnt[i] += cnt[i-1];
			if (cnt[i] == n) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(sum);
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
