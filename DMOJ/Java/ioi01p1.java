import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] array;
	static int s;
	public static void main(String[] args) throws IOException {
		int temp = readInt(); s = readInt();
		array = new int[s+1][s+1];
		while (true) {
			int n = readInt();
			if (n == 1) {
				int x = readInt()+1, y = readInt()+1, a = readInt();
				update(x,y,a);
			} else if (n == 2) {
				int l = readInt()+1, b = readInt()+1, r = readInt()+1, t = readInt()+1;
				System.out.println(query(r,t) - query(l-1,t) - query(r,b-1) + query(l-1,b-1));
			} else {
				break;
			}
		}
	}
	static void update(int x, int y, int a) {
		for (int i = y; i <= s; i += i & -i) {
			for (int j = x; j <= s; j += j & -j) {
				array[i][j] += a;
			}
		}
	}
	static long query(int x, int y) {
		long sum = 0;
		for (int i = y; i > 0; i -= i & -i) {
			for (int j = x; j > 0; j -= j & -j) {
				sum += array[i][j];
			}
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
