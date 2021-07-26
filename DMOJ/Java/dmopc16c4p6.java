import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		long[] array = new long[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readLong();
		}
		int max = 1000005;
		long[] ans = new long[max];
		Stack<Pair> s = new Stack<Pair>();
		s.add(new Pair(Integer.MIN_VALUE,0));
		for (int j = 1; j <= n; j++) {
			while (!s.isEmpty() && s.peek().val > array[j]) {
				int temp = s.peek().ind;
				ans[(int) s.pop().val] += (long)(temp - s.peek().ind) * (long)(j - temp);
			}
			s.add(new Pair(array[j],j));
		}
		while (s.size() > 1) {
			int temp = s.peek().ind;
			ans[(int) s.pop().val] += (long)(temp - s.peek().ind) * (long)(n + 1 - temp);
		}
		for (int i = 1; i < max; i++) {
			ans[i] += ans[i-1];
		}
		for (int i = 0; i < q; i++) {
			int a = readInt(), b = readInt();
			System.out.println((long)ans[b] - ans[a-1]);
		}
	}
	static class Pair{
		long val;
		int ind;
		Pair(long val, int ind){
			this.val = val;
			this.ind = ind;
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
