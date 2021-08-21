import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s = next(), t = next();
        Map<Character,Character> map = new HashMap();
        int freq[] = new int [26];
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), t.charAt(i));
            }
            else if (map.get(s.charAt(i)) != t.charAt(i)){
                System.out.println("No");
                return;
            }
        }
        for (char key: map.keySet()) {
            freq[map.get(key)-'a']++;
            if (freq[map.get(key)-'a'] > 1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
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
