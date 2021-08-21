import java.util.*;
import java.io.*;
public class LongestDiverseSubarrayWithinRange {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] s;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		HashMap<Integer,Integer> last = new HashMap();
		int[] array = new int[n+1];
		int[] left = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		for (int i = 1; i <= n; i++) {
			if (last.containsKey(array[i])) {
				left[i] = Math.min(left[i-1]+1, i-last.get(array[i]));
			} else {
				left[i] = left[i-1] + 1;
			}
			last.put(array[i], i);
		}
		s = new int[n+1][19];
		for (int i = 1; i <= n; i++) {
			s[i][0] = left[i];
		}
		for (int i = 1; 1 << i <= n; i++) {
			for (int j = 1; j + (1 << i) - 1 <= n; j++) {
				s[j][i] = Math.max(s[j][i-1], s[j+(1 << (i-1))][i-1]);
			}
		}
		//System.out.println(Arrays.toString(left));
		for (int i = 0; i < q; i++) {
			int l = readInt(), r = readInt();
			int k = l-1;
			int lo = l, hi = r;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (mid - left[mid] + 1 < l) {
					k = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			int ans = 0;
			if (k + 1 <= r) {
				ans = Math.max(k-l+1, get(k+1,r));
			} else {
				ans = k-l+1;
			}
			System.out.println(ans);
		}
	}
	static int get(int l, int r) {
		int size = (int)(Math.log(r-l+1) / Math.log(2));
		return Math.max(s[l][size], s[r-(1 << size)+1][size]);
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
