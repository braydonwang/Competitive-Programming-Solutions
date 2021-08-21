import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Stack<Pair> s = new Stack<Pair>();
		long ans = 0;
		for (int i = 0; i < n; i++) {
			long x = readLong();
			Pair p = new Pair(x,1);
			while (!s.isEmpty() && s.peek().a <= x) {
				ans += s.peek().b;
				if (s.peek().a == x) {
					p.b += s.peek().b;
				}
				s.pop();
			}
			if (!s.isEmpty()) {
				ans++;
			}
			//System.out.println(ans);
			s.add(p);
		}
		System.out.println(ans);
	}
	static class Pair{
		long a;
		int b;
		Pair(long a, int b){
			this.a = a;
			this.b = b;
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
