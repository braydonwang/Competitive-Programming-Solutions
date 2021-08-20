import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] bit;
	static int n;
	static int maxn;
	public static void main(String[] args) throws IOException {
		n = readInt();
		maxn = n+5;
		bit = new int[maxn][maxn];
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt()+1;
			update(i,array[i],1);
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int t = readInt();
			if (t == 1) {
				int l = readInt()+1, r = readInt()+1, a = readInt()+1, b = readInt()+1;
				System.out.println(query(r,b) - query(l-1,b) - query(r,a-1) + query(l-1,a-1));
			} else {
				int l = readInt()+1, h = readInt()+1;
				update(l,array[l],-1);
				array[l] = h;
				update(l,array[l],1);
			}
		}
	}
	static void update(int x, int y, int v) {
		for (int i = x; i < maxn; i += i&-i) {
			for (int j = y; j < maxn; j+= j&-j) {
				bit[i][j] += v;
			}
		}
	}
	static int query(int x, int y) {
		int total = 0;
		for (int i = x; i > 0; i -= i&-i) {
			for (int j = y; j > 0; j -= j&-j) {
				total += bit[i][j];
			}
		}
		return total;
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
