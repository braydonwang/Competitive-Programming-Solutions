import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		Pair[] array = new Pair[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(readInt(),readInt());
		}
		Arrays.sort(array);
		int l = 0, r = array[0].s - array[0].t;
		int ans = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (solve(mid,array)) {
				ans = Math.max(ans, mid);
				l = mid+1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(int mid, Pair[] array) {
		long total = mid + array[0].t;
		for (int i = 1; i < n; i++) {
			total += array[i].t;
			if (total > array[i].s) {
				return false;
			}
		}
		return true;
	}
	static class Pair implements Comparable<Pair>{
		int t,s;
		Pair(int t, int s){
			this.t = t;
			this.s = s;
		}
		public int compareTo(Pair p) {
			return this.s - p.s;
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
