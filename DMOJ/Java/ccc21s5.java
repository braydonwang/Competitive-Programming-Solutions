import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] seg = new int[(int)5e6+5];
	static int[] a;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] x = new int[m], y = new int[m], z = new int[m];
		a = new int[n+1];
		int[][] dif = new int[n+2][17];
		for (int i = 0; i < m; i++) {
			x[i] = readInt(); y[i] = readInt(); z[i] = readInt();
			dif[x[i]][z[i]]++; dif[y[i]+1][z[i]]--;
		}
		for (int i = 1; i <= n; i++) {
			int lcm = 1;
			for (int j = 1; j <= 16; j++) {
				dif[i][j] += dif[i-1][j];
				if (dif[i][j] > 0) {
					lcm = lcm * j / gcd(lcm,j);
				}
			}
			a[i] = lcm;
		}
		build(1,n,1);
		for (int i = 0; i < m; i++) {
			if (query(1,n,x[i],y[i],1) != z[i]) {
				System.out.println("Impossible");
				return;
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	static void build(int l, int r, int rt) {
		if (l == r) {
			seg[rt] = a[l]; return;
		}
		int mid = (l + r) / 2;
		build(l,mid,rt*2); build(mid+1,r,rt*2+1);
		seg[rt] = gcd(seg[rt*2],seg[rt*2+1]);
	}
	static int query(int ll, int rr, int l, int r, int rt) {
		if (ll >= l && rr <= r) {
			return seg[rt];
		}
		int mid = (ll + rr) / 2;
		if (r <= mid) {
			return query(ll,mid,l,r,2*rt);
		} else if (l > mid) {
			return query(mid+1,rr,l,r,2*rt+1);
		} else {
			return gcd(query(ll,mid,l,r,2*rt),query(mid+1,rr,l,r,2*rt+1));
		}
	}
	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
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
