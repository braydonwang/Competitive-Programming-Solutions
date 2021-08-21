import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), j = readInt();
		Pair[] array = new Pair[m+2];
		for (int i = 0; i < m; i++) {
			array[i] = new Pair(readInt(),readInt());
		}
		array[m] = new Pair(0,0); array[m+1] = new Pair(n+1,0);
		Arrays.sort(array);
		int[] ans = new int[m+2];
		Deque<Integer> q = new LinkedList();
		q.add(0);
		for (int i = 1; i <= m+1; i++) {
			while (!q.isEmpty() && array[i].p - array[q.getFirst()].p > j) {
				q.removeFirst();
			}
			if (q.isEmpty()) {
				System.out.println(-1);
				return;
			}
			ans[i] = Math.max(ans[q.getFirst()],array[i].t);
			while (!q.isEmpty() && ans[q.getLast()] >= ans[i]) {
				q.removeLast();
			}
			q.add(i);
		}
		System.out.println(ans[m+1]);
	}
	static class Pair implements Comparable<Pair>{
		int p,t;
		Pair(int p, int t){
			this.p = p;
			this.t = t;
		}
		public int compareTo(Pair a) {
			return this.p - a.p;
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
