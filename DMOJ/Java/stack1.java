import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt(), m = readInt();
		Deque<String> d = new LinkedList();
		for (int i = 0; i < t; i++) {
			String str = next(), temp = next();
			if (temp.equals("in")) {
				d.add(str);
			} else {
				if (d.getLast().equals(str)) {
					d.removeLast();
				} else if (d.getFirst().equals(str) && m >= 1) {
					d.removeFirst();
					m--;
				}
			}
		}
		for (String s: d) {
			System.out.println(s);
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
