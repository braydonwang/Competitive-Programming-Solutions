import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] pre = new int[(1<<23)+20];
		Deque<Pair> d = new LinkedList();
		d.add(new Pair(0,0));
		long x;
		for (int i = 1; i <= n+1; i++) {
			if (i <= n) {
				x = readLong();
			} else {
				x = 0;
			}
			while (!d.isEmpty() && d.getFirst().ind < i-k) {
				d.removeFirst();
			}
			long val = d.getFirst().val + x;
			pre[i] = d.getFirst().ind;
			while (!d.isEmpty() && d.getLast().val >= val) {
				d.removeLast();
			}
			d.add(new Pair(val,i));
		}
		int ind = n+1;
		System.out.println(d.getFirst().val);
		Stack<Integer> s = new Stack<Integer>();
		while (pre[ind] != 0) {
			s.add(pre[ind]);
			ind = pre[ind];
		}
		while (!s.isEmpty()){
		    System.out.print(s.pop() + " ");
		}
	}
	static class Pair{
		long val;
		int ind;
		Pair(long val, int ind){
			this.val = val;
			this.ind = ind;
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
