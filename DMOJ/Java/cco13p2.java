import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Pair[] tree;
	static int maxn = (int)3e6;
	static int num;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		tree = new Pair[maxn];
		num = 1 << n;
		for (int i = num; i < num*2; i++) {
			tree[i] = new Pair(readInt(),i-num+1);
		}
		build(1);
		for (int i = 0; i < m; i++) {
			char ch = readCharacter();
			if (ch == 'R') {
				int x = readInt(), y = readInt();
				int ind = x+num-1;
				tree[ind].val = y;
				for (int j = ind/2; j >= 1; j/=2) {
					if (tree[j*2].val < tree[j*2+1].val) {
						tree[j] = new Pair(tree[j*2+1].val,tree[j*2+1].ind);
					} else {
						tree[j] = new Pair(tree[j*2].val,tree[j*2].ind);
					}
				}
			} else if (ch == 'W') {
				System.out.println(tree[1].ind);
			} else {
				int x = readInt();
				int ind = x+num-1, temp = tree[ind].val;
				int count = 0;
				for (int j = ind/2; j >= 1; j/=2) {
					if (tree[j].val == temp) {
						count++;
					} else {
						break;
					}
				}
				System.out.println(count);
			}
		}
	}
	static void build(int pos) {
		if (pos >= num && pos < num*2) {
			return;
		}
		build(pos*2); build(pos*2+1);
		if (tree[pos*2].val < tree[pos*2+1].val) {
			tree[pos] = new Pair(tree[pos*2+1].val,tree[pos*2+1].ind);
		} else {
			tree[pos] = new Pair(tree[pos*2].val,tree[pos*2].ind);
		}
	}
	static class Pair{
		int val, ind;
		Pair(int val, int ind){
			this.val = val;
			this.ind = ind;
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
