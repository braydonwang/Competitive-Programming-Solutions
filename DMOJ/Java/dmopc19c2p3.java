import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] bit;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt(); int m = readInt();
		//bit[i][j] stores the number of numbers equal to i that have an index less than j
		bit = new int[21][n+1];
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
			update(array[i],i,1);
		}
		for (int i = 0; i < m; i++) {
			int x = readInt();
			if (x == 1) {
				int a = readInt(), b = readInt();
				update(array[a],a,-1);
				update(b,a,1);
				array[a] = b;
			} else {
				int l = readInt(), r = readInt(), c = readInt();
				int total = 0;
				//find the number of numbers that are greater than the current one
				//if the total is greater than or equal to c, you have found the cth largest number
				for (int j = 20; j >= 0; j--) {
					total += query(j,r) - query(j,l-1);
					if (total >= c) {
						System.out.println(j);
						break;
					}
				}
			}
		}
	}
	static void update(int x, int y, int val) {
		for (int j = y; j <= n; j += j&-j) {
			bit[x][j] += val;
		}
	}
	static int query(int x, int y) {
		int sum = 0;
		for (int j = y; j > 0; j -= j&-j) {
			sum += bit[x][j];
		}
		return sum;
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
