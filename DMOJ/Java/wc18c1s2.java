import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int w = readInt();
		int count = 0;
		HashSet<String> set = new HashSet<String>();
		for (int i = 'a'; i <= 'z'; i++) {
			char ch = (char) i;
			set.add(Character.toString(ch));
			if (set.size() == w) {
				print(set);
				return;
			}
		}
		for (int i = 'a'; i <= 'z'; i++) {
			for (int j = 'a'; j <= 'z'; j++) {
				String str = ((char) i) + "" + ((char) j);
				set.add(str);
				if (set.size() == w) {
					print(set);
					return;
				}
			}
		}
		for (int i = 'a'; i <= 'z'; i++) {
			for (int j = 'a'; j <= 'z'; j++) {
				for (int k = 'a'; k <= 'z'; k++) {
					String str = ((char) i) + "" + ((char) j) + ((char)k); 
					set.add(str);
					if (set.size() == w) {
						print(set);
						return;
					}
				}
			}
		}
	}
	static void print(HashSet<String> set) {
		for (String s: set) {
			System.out.print(s + " ");
		}
		System.out.println();
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
