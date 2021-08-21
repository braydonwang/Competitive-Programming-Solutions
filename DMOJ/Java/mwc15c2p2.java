import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n+1];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		array[1] = Integer.MAX_VALUE;
		stack.add(1);
		System.out.print(0 + " ");
		for (int i = 2; i <= n; i++) {
			while (!stack.isEmpty()) {
				if (array[stack.peek()] <= array[i]) {
					stack.pop();
				} else {
					break;
				}
			}
			System.out.print(i - stack.peek() + " ");
			stack.push(i);
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
