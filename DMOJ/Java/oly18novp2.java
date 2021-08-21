import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n; i++) {
			int d = readInt(), p = readInt();
			adj[d].add(p);
		}
		PriorityQueue<Number> q = new PriorityQueue<Number>();
		long ans = 0;
		for (int i = n; i >= 1; i--) {
			for (int num: adj[i]) {
				q.add(new Number(num));
			}
			if (!q.isEmpty()) {
				ans += q.poll().ind;
			}
		}
		System.out.println(ans);
	}
	static class Number implements Comparable<Number>{
		int ind;
		Number(int ind){
			this.ind = ind;
		}
		public int compareTo(Number m) {
			return m.ind - this.ind;
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
