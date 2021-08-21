import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			int n = readInt();
			Deque<Integer> a = new LinkedList();
			Deque<Integer> b = new LinkedList();
			Deque<Integer> c = new LinkedList();
			for (int j = 0; j < n; j++) {
				int x = readInt();
				a.add(x);
				c.add(x);
			}
			b.add(a.removeFirst());
			boolean good = true;
			for (int j = 1; j < n; j++) {
				if (a.getFirst() == b.getFirst()-1) {
					b.addFirst(a.removeFirst());
				} else if (a.getFirst() == b.getLast()+1) {
					b.addLast(a.removeFirst());
				} else if (a.getLast() == b.getFirst()-1) {
					b.addFirst(a.removeLast());
				} else if (a.getLast() == b.getLast()+1) {
					b.addLast(a.removeLast());
				} else {
					good = false;
					break;
				}
			}
			if (good) {
				System.out.println("Case #" + (i+1) + ": yes");
			} else {
				good = true;
				b.clear();
				b.add(c.removeLast());
				for (int j = 1; j < n; j++) {
					if (c.getFirst() == b.getFirst()-1) {
						b.addFirst(c.removeFirst());
					} else if (c.getFirst() == b.getLast()+1) {
						b.addLast(c.removeFirst());
					} else if (c.getLast() == b.getFirst()-1) {
						b.addFirst(c.removeLast());
					} else if (c.getLast() == b.getLast()+1) {
						b.addLast(c.removeLast());
					} else {
						good = false;
						break;
					}
				}
				if (good) {
					System.out.println("Case #" + (i+1) + ": yes");
				} else {
					System.out.println("Case #" + (i+1) + ": no");
				}
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
