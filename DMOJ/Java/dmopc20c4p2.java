import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		long n = readLong(), m = readLong();
		int k = readInt();
		HashMap<Long,Integer> row = new HashMap(), col = new HashMap();
		for (int i = 0; i < k; i++) {
			long a = readLong(), b = readLong();
			row.put(a, row.getOrDefault(a,0)+1); col.put(b, col.getOrDefault(b,0)+1);
		}
		Stack<Long> r = new Stack(), c = new Stack();
		for (long key: row.keySet()) {
			if (row.get(key) % 2 != 0) {
				r.add(key);
			}
		}
		for (long key: col.keySet()) {
			if (col.get(key) % 2 != 0) {
				c.add(key);
			}
		}
		System.out.println(Math.max(r.size(), c.size()));
		while (!r.isEmpty() || !c.isEmpty()) {
			if (r.isEmpty()) {
				System.out.println("1 " + c.pop());
			} else if (c.isEmpty()) {
				System.out.println(r.pop() + " 1");
			} else {
				System.out.println(r.pop() + " " + c.pop());
			}
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
