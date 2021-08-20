import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			int n = readInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = readInt();
			}
			Stack<Integer> st = new Stack();
			int count = 1;
			for (int i = n-1; i >= 0; i--) {
				st.push(array[i]);
				while (!st.isEmpty() && st.peek() == count) {
					st.pop();
					count++;
				}
			}
			if (count > n) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
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
