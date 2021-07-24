import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m;
	static int max = (int)3e6;
	static int[] a;
	static Node[] tree = new Node[max];
	static int[] lazy = new int[max];
	public static void main(String[] args) throws IOException {
		m = readInt();
		int n = readInt(), q = readInt();
		a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		build(1,1,n);
		for (int i = 0; i < q; i++) {
			int num = readInt();
			if (num == 1) {
				int l = readInt(), r = readInt(), x = readInt();
				update(1,l,r,x%m);
			} else {
				int l = readInt(), r = readInt();
				System.out.println(query(1,l,r) % m);
			}
		}
	}
	static int build(int pos, int l, int r) {
		if (l == r) {
			tree[pos] = new Node(l,r,a[l]%m);
			return tree[pos].val % m;
		}
		int mid = (l + r) / 2;
		tree[pos] = new Node(l,r,0);
		return tree[pos].val = (build(pos*2,l,mid) % m + build(pos*2+1,mid+1,r) % m) % m;
	}
	static void push(int pos, int l, int r) {
		if (lazy[pos] != 0) {
			tree[pos].val = (tree[pos].val % m + ((r - l + 1) * lazy[pos]) % m) % m;
			lazy[pos*2] = (lazy[pos*2] % m + lazy[pos] % m) % m;
			lazy[pos*2+1] = (lazy[pos*2+1] % m + lazy[pos] % m) % m;
			lazy[pos] = 0;
		}
	}
	static int update(int pos, int ll, int rr, int x) {
		int l = tree[pos].l, r = tree[pos].r;
		push(pos,l,r);
		if (l > rr || r < ll) {
			return tree[pos].val % m;
		}
		if (l >= ll && r <= rr) {
			tree[pos].val = (tree[pos].val % m + ((r - l + 1) * x) % m) % m;
			lazy[pos*2] = (lazy[pos*2] % m + x % m) % m;
			lazy[pos*2+1] = (lazy[pos*2+1] % m + x % m) % m;
			return tree[pos].val % m;
		}
		return tree[pos].val = (update(pos*2,ll,rr,x) % m + update(pos*2+1,ll,rr,x) % m) % m;
	}
	static int query(int pos, int ll, int rr) {
		int l = tree[pos].l, r = tree[pos].r;
		push(pos,l,r);
		if (l > rr || r < ll) {
			return 0;
		}
		if (l >= ll && r <= rr) {
			return tree[pos].val % m;
		}
		return (query(pos*2,ll,rr) % m + query(pos*2+1,ll,rr) % m) % m;
	}
	static class Node{
		int l, r, val;
		Node(int l, int r, int val){
			this.l = l;
			this.r = r;
			this.val = val;
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
