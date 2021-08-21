import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), c = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		Deque<Integer> max = new LinkedList();
		Deque<Integer> min = new LinkedList();
		boolean good = false;
		for (int i = 0; i < n; i++) {
			if (i >= m) {
				if (max.getFirst() == i-m) {
					max.removeFirst();
				}
				if (min.getFirst() == i-m) {
					min.removeFirst();
				}
			}
			while (!max.isEmpty() && array[max.getLast()] < array[i]) {
				max.removeLast();
			}
			while (!min.isEmpty() && array[min.getLast()] > array[i]) {
				min.removeLast();
			}
			max.add(i); min.add(i);
			if (i >= m-1 && array[max.getFirst()] - array[min.getFirst()] <= c) {
				System.out.println(i - m + 2);
				good = true;
			}
		}
		if (!good) {
			System.out.println("NONE");
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
