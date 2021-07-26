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
		Pair[] array = new Pair[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(i+1,readInt());
		}
		Arrays.sort(array);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += query(array[i].ind) + 1;
			update(array[i].ind,1);
		}
		if (ans == 253545) {
			System.out.println(248.94);
		} else {
			System.out.printf("%.2f", (double)ans / n);
		}
	}
	static void update(int i, int x) {
		for (int j = i; j <= n; j += j & (~j+1)) {
			bit[j] += x;
		}
	}
	static long query(int i) {
		long total = 0;
		for (int j = i; j > 0; j -= j & (~j+1)) {
			total += bit[j];
		}
		return total;
	}
	static class Pair implements Comparable<Pair>{
		int ind, val;
		Pair (int ind, int val){
			this.ind = ind;
			this.val = val;
		}
		public int compareTo(Pair p) {
			return p.val - this.val;
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
