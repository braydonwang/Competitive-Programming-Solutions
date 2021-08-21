import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int s;
	public static void main(String[] args) throws IOException {
		s = readInt();
		int n = readInt();
		Quad[] a = new Quad[n];
		for (int i = 1; i <= n; i++) {
			a[i-1] = new Quad(readInt(),readInt(),readInt(),i);
		}
		Arrays.sort(a);
		int q = readInt();
		for (int i = 0; i < q; i++) {
			System.out.println(a[readInt()-1].ind);
		}
	}
	static class Quad implements Comparable<Quad>{
		int b, c, d, ind;
		Quad(int b, int d, int c, int ind){
			this.b = b;
			this.c = c;
			this.d = d;
			this.ind = ind;
		}
		public int compareTo(Quad q) {
			if (this.b != q.b) {
				return q.b - this.b;
			} else {
				if (this.b >= s) {
					if (this.c == q.c) {
						return this.ind - q.ind;
					} else {
						return q.c - this.c;
					}
				} else {
					if (this.d == q.d) {
						return this.ind - q.ind;
					} else {
						return q.d - this.d;
					}
				}
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
