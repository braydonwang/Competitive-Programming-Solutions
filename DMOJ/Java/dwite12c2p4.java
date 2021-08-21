import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			int n = readInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = n; i >= 1; i--) {
				list.add(i);
			}
			int[] ans = new int[n];
			boolean impossible = false;
			for (int i = 0; i < n; i++) {
				int x = readInt();
				if (x >= list.size()) {
					impossible = true;
					break;
				} else {
					ans[i] = list.get(x);
					list.remove(x);
				}
			}
			if (impossible) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int i = 0; i < n-1; i++) {
					System.out.print(ans[i] + " ");
				}
				System.out.println(ans[n-1]);
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
