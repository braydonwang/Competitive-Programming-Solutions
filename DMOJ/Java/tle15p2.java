import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		long n = readLong(), m = readLong(), t = readLong();
		Pair[] array = new Pair[(int)m];
		for (int i = 0; i < m; i++) {
			array[i] = new Pair(readLong(),readLong());
		}
		Arrays.sort(array);
		long[] end = new long[(int)n];
		for (int i = 0; i < m; i++) {
			int lo = 0, hi = (int) (n-1);
			int ans = -1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (end[mid] <= array[i].t) {
					ans = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			if (array[i].t - end[0] >= t) {
				System.out.println(end[0]);
				return;
			}
			if (ans == -1) {
				end[0] += array[i].f;
			} else {
				end[ans] = array[i].t + array[i].f;
			}
			Arrays.sort(end);
		}
		System.out.println(end[0]);
	}
	static class Pair implements Comparable<Pair>{
		long t, f;
		Pair(long t, long f){
			this.t = t;
			this.f = f;
		}
		public int compareTo(Pair p) {
			return (int)(this.t - p.t);
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
