import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static boolean isPrime(int n) {
		if (n <= 1) {  
			return false;  
		 }  
		 for (int i = 2; i <= Math.sqrt(n); i++) {  
			 if (n % i == 0) {  
				 return false;  
			 }  
		 }  
		 return true;  
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		List<Integer> adj[] = new ArrayList[n+1];
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> t = new LinkedList<>();
		boolean vis1[] = new boolean[n+1];
		boolean vis2[] = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int x = readInt(), y = readInt();
			adj[y].add(x);
		}
		int a = readInt(), b = readInt();
		q.add(a); vis1[a] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				if (nxt == b) {
					System.out.println("no");
					return;
				}
				if (!vis1[nxt]) {
					q.add(nxt);
					vis1[nxt] = true;
				}
			}
		}
		t.add(b); vis2[b] = true;
		while (!t.isEmpty()) {
			int cur = t.poll();
			for (int nxt: adj[cur]) {
				if (nxt == a) {
					System.out.println("yes");
					return;
				}
				if (!vis2[nxt]) {
					t.add(nxt);
					vis2[nxt] = true;
				}
			}
		}
		System.out.println("unknown");
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
