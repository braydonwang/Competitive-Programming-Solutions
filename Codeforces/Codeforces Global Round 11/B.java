import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			int n = readInt(), k = readInt();
			char[] array = next().toCharArray();
			int pre = -1;
			ArrayList<Integer> list = new ArrayList<Integer>();
			int w = 0;
			for (int i = 0; i < n; i++) {
				if (array[i] == 'W') {
					w++;
					if (pre == -1) {
						pre = i;
					} else {
						list.add(i-pre-1);
						pre = i;
					}
				}
			}
			Collections.sort(list);
			int og = k;
			int cnt = list.size();
			for (int x: list) {
				if (k >= x) {
					k -= x;
					cnt--;
				} else {
					break;
				}
			}
			if (w == 0) {
				System.out.println(Math.max(0, 2*k-1));
			} else {
				System.out.println(2*Math.min(n, w+og) - cnt -1);
			}
		}
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
