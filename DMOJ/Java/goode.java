import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] tree = new int[(int)5e6], lazy = new int[(int)5e6];
	static int t;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		t = readInt();
		build(1,n,1);
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			update(1,n,1,a,b);
			//print(1,n,1);
			int num = query(1,n,1,0);
			if (tree[1] < t) {
				System.out.println("AC?");
			} else {
				System.out.println(num);
			}
		}
	}
	static void print(int l, int r, int pos) {
		if (l == r) {
			System.out.println(l + " " + r + " " + tree[pos]);
			return;
		}
		System.out.println(l + " " + r + " " + tree[pos]);
		int mid = (l + r) / 2;
		print(l,mid,pos*2); print(mid+1,r,pos*2+1);
	}
	static void push(int pos, int l, int r) {
		if (lazy[pos] % 2 != 0) {
			tree[pos] = r - l + 1 - tree[pos];
			lazy[pos*2] += lazy[pos];
			lazy[pos*2+1] += lazy[pos];
			lazy[pos] = 0;
		}
	}
	static int update(int l, int r, int pos, int a, int b) {
		push(pos,l,r);
		if (l > b || r < a) {
			return tree[pos];
		} else if (a <= l && b >= r) {
			tree[pos] = r - l + 1 - tree[pos];
			lazy[pos*2]++;
			lazy[pos*2+1]++;
			return tree[pos];
		}
		int mid = (l + r) / 2;
		return tree[pos] = update(l,mid,pos*2,a,b) + update(mid+1,r,pos*2+1,a,b);
	}
	static int query(int l, int r, int pos, int count) {
		push(pos,l,r);
		if (l == r) {
			return l;
		}
		int mid = (l + r) / 2;
		push(pos*2,l,mid); push(pos*2+1,mid+1,r);
		if (tree[pos*2] + count < t) {
			return query(mid+1,r,pos*2+1,count + tree[pos*2]);
		} else {
			return query(l,mid,pos*2,count);
		}
	}
	static int build(int l, int r, int pos) {
		if (l == r) {
			return tree[pos] = 1;
		}
		int mid = (l + r) / 2;
		return tree[pos] = build(l,mid,pos*2) + build(mid+1,r,pos*2+1);
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
