import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] bit;
	static int max = (int) (1e6+1);
	static int[] dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int ans = 0;
		bit = new int[max];
		Arrays.fill(bit, -1);
		Pair[] array = new Pair[n];
		dp = new int[n];
		int[] pre = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(readInt(),readInt());
		}
		Arrays.sort(array);
		for (int i = 0; i < n; i++) {
			int temp = query(array[i].r);
			if (temp == -1) {
				dp[i] = 1;
				pre[i] = -1;
			} else {
				dp[i] = dp[temp] + 1;
				pre[i] = temp;
				if (dp[i] > dp[ans]) {
					ans = i;
				}
			}
			update(array[i].r,i);
		}
		System.out.println(dp[ans]);
		while (ans != -1) {
			System.out.println(array[ans].l + " " + array[ans].r);
			ans = pre[ans];
		}
	}
	static void update(int x, int val) {
		for (int i = x; i < max; i += i & -i) {
			if (bit[i] == -1 || dp[bit[i]] < dp[val]) {
				bit[i] = val;
				//System.out.println(i);
			}
		}
	}
	static int query(int x) {
		int ans = -1;
		for (int i = x; i > 0; i -= i & -i) {
			//System.out.println(i);
			if (bit[i] != -1 && (ans == -1 || dp[bit[i]] > dp[ans])) {
				ans = bit[i];
			}
		}
		return ans;
	}
	static class Pair implements Comparable<Pair>{
		int l, r;
		Pair(int l, int r){
			this.l = l;
			this.r = r;
		}
		public int compareTo(Pair p) {
			if (this.l == p.l) {
				return this.r - p.r;
			}
			return p.l - this.l;
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
