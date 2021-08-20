import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int count;
	static int num;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		count = 0;
		num = n;
		int[] array = new int[n];
		solve(1,n,array,0);
		System.out.println("total=" + count);
	}
	static void solve(int x, int n, int[] array, int ind) {
		if (n < 0) {
			return;
		}
		if (n == 0 && array[ind-1] != num) {
			System.out.print(num + "=");
			for (int i = 0; i < ind-1; i++) {
				System.out.print(array[i]+"+");
			}
			System.out.println(array[ind-1]);
			count++;
		}
		for (int i = x; i <= n; i++) {
			array[ind] = i;
			solve(i,n-i,array,ind+1);
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
