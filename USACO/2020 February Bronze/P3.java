import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int a1, a2, b1, b2;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		a1 = readInt(); a2 = readInt(); b1 = readInt(); b2 = readInt();
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int x = check(i,i,0);
			int a = i;
			for (int j = 0; j < k%x; j++) {
				a = num(a);
			}
			array[a] = i;
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(array[i]);
		}
	}
	static int check(int ind, int og, int count) {
		if (ind >= a1 && ind <= a2) {
			ind = a2 - (ind - a1);
		}
		if (ind >= b1 && ind <= b2) {
			ind = b2 - (ind - b1);
		}
		count++;
		if (ind == og) {
			return count;
		} else {
			return check(ind,og,count);
		}
	}
	static int num(int ind) {
		if (ind >= a1 && ind <= a2) {
			ind = a2 - (ind - a1);
		}
		if (ind >= b1 && ind <= b2) {
			ind = b2 - (ind - b1);
		}
		return ind;
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
