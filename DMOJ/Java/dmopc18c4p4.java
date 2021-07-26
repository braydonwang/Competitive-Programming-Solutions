import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] bit;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt(); int q = readInt();
		bit = new long[n+1];
		Pair[] array = new Pair[n+1];
		int[] l = new int[q], r = new int[q];
		Pair[] queries = new Pair[q];
		array[0] = new Pair(0,0);
		for (int i = 1; i <= n; i++) {
			int num = readInt();
			array[i] = new Pair(num,i);
			update(i,num);
		}
		Arrays.sort(array);
		for (int i = 0; i < q; i++) {
			l[i] = readInt(); r[i] = readInt();
			int k = readInt();
			queries[i] = new Pair(k,i);
		}
		Arrays.sort(queries);
		int temp = 1;
		long[] ans = new long[q];
		for (int i = 0; i < q; i++) {
			while (temp <= n && queries[i].k > array[temp].k) {
				update(array[temp].ind,array[temp].k * -2);
				temp++;
			}
			ans[queries[i].ind] = query(r[queries[i].ind]) - query(l[queries[i].ind]-1);
		}
		for (long x: ans) {
			System.out.println(x);
		}
	}
	static class Pair implements Comparable<Pair>{
		int k, ind;
		Pair(int k, int ind){
			this.k = k;
			this.ind = ind;
		}
		public int compareTo(Pair p) {
			return this.k - p.k;
		}
	}
	static void update(int x, long v) {
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
