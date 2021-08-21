import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), r = readInt();
		boolean[] array = new boolean[n+1];
		for (int i = 0; i < k; i++) {
			array[readInt()] = true;
		}
		Deque<Integer> d = new LinkedList();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!array[i]) {
				d.add(i);
			}
			while (!d.isEmpty() && i >= r && r - d.size() < 2) {
				count++;
				d.removeLast();
			}
			while (!d.isEmpty() && d.getFirst() <= i - r + 1) {
				d.removeFirst();
			}
		}
		System.out.println(count);
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
