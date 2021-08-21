import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] bit;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		bit = new int[n+1];
		long total = 0;
		for (int i = 0; i < n; i++) {
			int num = readInt();
			update(num,1);
			total += Math.min(query(num-1), query(n) - query(num));
		}
		System.out.println(total);
	}
	static void update(int x, int v) {
		for (int i = x; i <= n; i += i & -i) {
			bit[i] += v;
		}
	}
	static long query(int x) {
		long sum = 0;
		for (int i = x; i > 0; i -= i & -i) {
			sum += bit[i];
		}
		return sum;
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
