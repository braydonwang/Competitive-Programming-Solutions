import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		long a = readLong(), b = readLong();
		long[] array = {a-2,a,a+2,b-2,b,b+2,2};
		boolean[] vis = new boolean[7];
		int[] dis = new int[7];
		int[] pre = new int[7];
		Queue<Integer> q = new LinkedList();
		q.add(1); vis[1] = true; dis[1] = 1; pre[1] = -1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < 7; i++) {
				if (i != cur) {
					if (!vis[i] && isPrime(array[i]) && isPrime(Math.abs(array[cur]-array[i]))) {
						q.add(i); vis[i] = true; dis[i] = dis[cur] + 1; pre[i] = cur;
					}
				}
			}
			if (vis[4]) {
				break;
			}
		}
		if (vis[4]) {
			System.out.println(dis[4]);
			Stack<Long> s = new Stack<Long>();
			int temp = 4;
			for (int i = 0; i < dis[4]; i++) {
				s.add(array[temp]);
				temp = pre[temp];
			}
			for (int i = 0; i < dis[4]; i++) {
				System.out.print(s.pop() + " ");
			}
		} else {
			System.out.println(-1);
		}
	}
	static boolean isPrime(long x) {
		if (x == 1 || x == 0) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
