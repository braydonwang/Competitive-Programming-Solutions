import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		HashSet<Integer> top = new HashSet<Integer>();
		HashSet<Integer> bot = new HashSet<Integer>();
		int[] array = new int[r];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				array[i] = (array[i] << 1) + readInt();
			}
		}
		top.add(array[0]);
		for (int i = 1; i < r; i++) {
			bot.clear();
			bot.add(array[i]);
			for (int j: top) {
				bot.add(j ^ array[i]);
			}
			top.clear();
			for (int j: bot) {
				top.add(j);
			}
		}
		System.out.println(bot.size());
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
