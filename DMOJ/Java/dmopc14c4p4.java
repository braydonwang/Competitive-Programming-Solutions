import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = next();
		int n = str.length();
		String t = "HAILHYDRA";
		Set<String> list = new HashSet();
		int[] freq = new int[26];
		int[] freq2 = new int[10];
		for (int i = 0; i < n; i++) {
			freq[str.charAt(i)-'A']++;
			freq2[freq[str.charAt(i)-'A']]++;
			freq2[freq[str.charAt(i)-'A']-1]--;
			if (i > 8) {
				freq[str.charAt(i-9)-'A']--;
				freq2[freq[str.charAt(i-9)-'A']]++;
				freq2[freq[str.charAt(i-9)-'A']+1]--;
			}
			if (i >= 8) {
				if (freq2[1] == 5 && str.charAt(i-4) == str.charAt(i-8) && str.charAt(i) == str.charAt(i-7)) {
					list.add(str.substring(i-8,i+1));
				}
			}
		}
		int a = readInt();
		for (int i = 0; i < a; i++) {
			String map = next();
			StringBuilder b = new StringBuilder(9);
			for (int j = 0; j < 9; j++) {
				b.append(map.charAt(t.charAt(j)-'A'));
			}
			if (list.contains(b.toString())) {
				char[] array = new char[26];
				for (int j = 0; j < 26; j++) {
					array[map.charAt(j)-'A'] = (char)(j+'A');
				}
				for (int j = 0; j < n; j++) {
					System.out.print(array[str.charAt(j)-'A']);
				}
				System.out.println();
				return;
			}
		}
		System.out.println("KeyNotFoundError");
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
