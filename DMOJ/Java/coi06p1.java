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
			int x = readInt();
			Pair p = new Pair(x,1);
			while (!s.isEmpty() && s.peek().val <= x) {
				if (s.peek().val == x) {
					p.freq += s.peek().freq;
					ans += s.pop().freq;
					break;
				} else {
					ans += s.pop().freq;
				}
			}
			if (!s.isEmpty()) {
				ans++;
			}
			s.add(p);
		}
		System.out.println(ans);
	}
	static class Pair{
		int val, freq;
		Pair(int val, int freq){
			this.val = val;
			this.freq = freq;
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
