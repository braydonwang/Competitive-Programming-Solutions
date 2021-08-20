import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int sum = 0;
		int[] mod = new int[n];
		for (int i = 0; i < n; i++) {
			sum += readInt();
			sum %= k;
			mod[i] = sum % k;
		}
		int max = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < n; i++) {
			if (mod[i] == 0) {
				max = i+1;
			} else if (!map.containsKey(mod[i])) {
				map.put(mod[i],i);
			} else {
				max = Math.max(max, i-map.get(mod[i]));
			}
		}
		System.out.println(max == 0 ? -1 : max);
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
