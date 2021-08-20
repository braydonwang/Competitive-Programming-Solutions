import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int l = readInt() % 26;
		String str = readLine();
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				int temp = str.charAt(i) + l;
				if (temp > 'z') {
					temp = temp % 'z' + 'a' - 1;
				}
				ans += (char)(temp);
			} else {
				ans += " ";
			}
		}
		System.out.println(ans);
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
