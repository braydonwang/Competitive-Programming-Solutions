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
		Arrays.fill(bit,Integer.MAX_VALUE);
		int[] a = new int[n+1], b = new int[n+1], c = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[readInt()] = i;
		}
		for (int i = 1; i <= n; i++) {
			b[readInt()] = i;
		}
		for (int i = 1; i <= n; i++) {
			c[readInt()] = i;
		}
		Triple[] array = new Triple[n];
		for (int i = 1; i <= n; i++) {
			array[i-1] = new Triple(a[i],b[i],c[i]);
		}
		Arrays.sort(array);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int temp = query(array[i].b);
			if (temp > array[i].c) {
				//System.out.println(i);
				ans++;
			}
			update(array[i].b,array[i].c);
		}
		System.out.println(ans);
	}
	static int query(int x) {
		int tot = Integer.MAX_VALUE;
		for (int i = x; i > 0; i -= i&-i) {
			tot = Math.min(tot, bit[i]);
		}
		return tot;
	}
	static void update(int x, int y) {
		for (int i = x; i <= n; i += i&-i) {
			bit[i] = Math.min(bit[i], y);
		}
	}
	static class Triple implements Comparable<Triple>{
		int a, b, c;
		Triple(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public int compareTo(Triple t) {
			return this.a - t.a;
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
