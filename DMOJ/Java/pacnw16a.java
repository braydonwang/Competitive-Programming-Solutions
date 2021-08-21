import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = next();
		List<Integer> list = new ArrayList();
		for (int i = 0; i < str.length(); i++) {
			int x = str.charAt(i) - 'a';
			if (list.isEmpty() || x > list.get(list.size()-1)) {
				list.add(x);
			} else {
				int p = Collections.binarySearch(list, x);
				if (p < 0) {
					p = -p-1; list.set(p, x);
				}
			}
		}
		System.out.println(26-list.size());
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
