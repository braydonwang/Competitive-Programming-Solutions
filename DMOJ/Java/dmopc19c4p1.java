import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			String str = next();
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					count++;
				} else if (str.charAt(j) == ')') {
					count--;
				}
				if (count < 0){
				    break;
				}
			}
			if (count == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
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
