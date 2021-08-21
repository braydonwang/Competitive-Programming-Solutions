import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[] array = new long[n+1];
		long[] pre = new long[n+k+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readLong();
			pre[i] = pre[i-1] + array[i];
		}
		for (int i = n+1; i <= n+k; i++) {
			pre[i] = pre[i-1] + array[i-n];
		}
		Deque<Pair> q = new LinkedList<Pair>();
		long max = Long.MIN_VALUE;
		for (int i = 1; i <= n+k; i++) {
			while (!q.isEmpty() && q.getFirst().ind < i - k) {
				q.removeFirst();
			}
			while (!q.isEmpty() && q.getLast().val > pre[i]) {
				q.removeLast();
			}
			q.addLast(new Pair(i,pre[i]));
			max = Math.max(max, pre[i] - q.getFirst().val);
		}
		System.out.println(max);
	}
	static class Pair{
		int ind;
		long val;
		Pair(int ind, long val){
			this.ind = ind;
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
