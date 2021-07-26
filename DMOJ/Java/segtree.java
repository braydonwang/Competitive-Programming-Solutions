import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int maxn = (int)3e5;
	static Node[] tree = new Node[maxn];
	static int[] array;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			int x = readInt();
			array[i] = x;
		}
		construct(0,n-1,1);
		for (int i = 0; i < m; i++) {
			char ch = readCharacter();
			if (ch == 'M') {
				int x = readInt(), y = readInt();
				update(x, y, 1);
			} else {
				int l = readInt(), r = readInt();
				System.out.println(query(l,r,1));
			}
		}
	}
	static int query(int a, int b, int pos) {
		int l = tree[pos].l, r = tree[pos].r;
		if (r < a || l > b) {
			return Integer.MAX_VALUE;
		}
		if (a <= l && r <= b) {
			return tree[pos].val;
		}
		return Math.min(query(a,b,pos*2),query(a,b,pos*2+1)); 
	}
	static void update(int x, int y, int pos) {
		int l = tree[pos].l, r = tree[pos].r;
		if (l > x || r < x) {
			return;
		}
		if (l == r && r == x) {
			tree[pos].val = y;
			return;
		}
		update(x,y,pos*2); update(x,y,pos*2+1);
		push(pos);
	}
	static void push(int pos) {
		tree[pos].val = Math.min(tree[pos*2].val, tree[pos*2+1].val);
	}
	static void construct(int l, int r, int pos) {
		tree[pos] = new Node(l,r,0);
		if (l == r) {
			tree[pos].val = array[l];
			return;
		}
		int mid = (l + r) / 2;
		construct(l,mid,pos*2); construct(mid+1,r,pos*2+1);
		push(pos);
	}
	static class Node{
		int l, r, val;
		Node(int l, int r, int val){
			this.l = l;
			this.r = r;
			this.val = val;
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
