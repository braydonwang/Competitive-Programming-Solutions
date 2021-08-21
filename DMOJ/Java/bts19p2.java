import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt(), y = readInt(), h = readInt(), v = readInt();
		int t = readInt()-1;
		int curx = 0, cury = 0;
		while (t > 0) {
			if ((x - curx > y - cury || (x - curx == y - cury && h > v)) && curx + 2 < x + h) {
				curx += 2;
				cury++;
			} else {
				curx++;
				cury += 2;
			}
			if (curx >= x && curx < x + h && cury >= y && cury < y + v) {
				break;
			}
			t--;
		}
		if (t > 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
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
