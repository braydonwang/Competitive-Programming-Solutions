import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		Range[] array = new Range[m];
		long hi = 0;
		for (int i = 0; i < m; i++) {
			long a = readLong(), b = readLong();
			array[i] = new Range(a,b);
			hi = Math.max(hi, b);
		}
		Arrays.sort(array);
		long lo = 1;
		long ans = 0;
		while (lo <= hi) {
			long mid = (lo + hi) / 2;
			if (solve(mid,array,n)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(long d, Range[] array, int n) {
		int count = 0;
		long num = Long.MIN_VALUE;
		for (Range i: array) {
			while (Math.max(num+d, i.a) <= i.b) {
				num = Math.max(num+d, i.a);
				count++;
				if (count >= n) {
					break;
				}
			}
			if (count >= n) {
				break;
			}
		}
		return (count >= n);
	}
	static class Range implements Comparable<Range>{
		long a, b;
		Range(long a, long b){
			this.a = a;
			this.b = b;
		}
		public int compareTo(Range r) {
			return (int) (this.a - r.a);
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
