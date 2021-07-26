import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int k = readInt();
		for (int a = 0; a < k; a++) {
			int r = readInt(), c = readInt();
			int[] his = new int[c];
			int max = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					char ch = next().charAt(0);
					if (ch == 'R') {
						his[j] = 0;
					} else {
						his[j]++;
					}
				}
				Stack<Integer> s = new Stack();
				int ind = 0;
				while (ind < c) {
					if (s.isEmpty() || his[s.peek()] <= his[ind]) {
						s.push(ind);
						ind++;
					} else {
						int cur = his[s.pop()], area = 0, lh = 0;
						if (s.isEmpty()) {
							lh = -1;
						} else {
							lh = s.peek();
						}
						area = (ind - lh - 1) * cur;
						max = Math.max(max, area);
					}
				}
				while (!s.isEmpty()) {
					int cur = his[s.pop()], area = 0, lh = 0;
					if (s.isEmpty()) {
						lh = -1;
					} else {
						lh = s.peek();
					}
					area = (ind - lh - 1) * cur;
					max = Math.max(max, area);
				}
			}
			System.out.println(max*3);
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
