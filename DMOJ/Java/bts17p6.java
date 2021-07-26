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
		Map<Integer,Integer> map = new HashMap();
		int[] pos2 = new int[n+1];
		for (int i = 1; i <= n; i++) {
			map.put(readInt(),i);
		}
		for (int i = 1; i <= n; i++) {
			int x = readInt();
			pos2[i] = map.get(x);
		}
		int change = 1, len = 1, l = 1, r = 1;
		for (int i = 2; i <= n; i++) {
			if (pos2[i] < pos2[i-1]) {
				change = i;
			}
			if (i - change + 1 > len) {
				len = i - change + 1;
				l = change; r = i;
			}
		}
		System.out.println(n-len);
		for (int i = 1; i <= n; i++) {
			update(i,1);
		}
		for (int i = r+1; i <= n; i++) {
			int sum = query(pos2[i]);
			update(pos2[i],-1);
			System.out.println("B " + sum);
		}
		int cnt = 0;
		for (int i = l-1; i >= 1; i--, cnt++) {
			int sum = query(pos2[i]) + cnt;
			update(pos2[i],-1);
			System.out.println("F " + sum);
		}
	}
	static void update(int x, int v) {
		for (int i = x; i <= n; i += i&-i) {
			bit[i] += v;
		}
	}
	static int query(int x) {
		int total = 0;
		for (int i = x; i > 0; i -= i&-i) {
			total += bit[i];
		}
		return total;
	}
	static class Pair implements Comparable<Pair>{
		int ind;
		long val;
		Pair(int ind, long val){
			this.ind = ind;
			this.val = val;
		}
		public int compareTo(Pair p) {
			if (this.val < p.val) {
				return -1;
			} else if (this.val == p.val) {
				return 0;
			} else {
				return 1;
			}
		}
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
