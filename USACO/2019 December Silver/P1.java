import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int temp = n / 8;
		n = n % 8;
		if (n == 0) {
			n = 8;
			temp--;
		}
		int[] array = {1,2,0,4,0,0,7,8,0,0,11,0,13,14,0};
		int count = 1;
		for (int i = 0; i < 15; i++) {
			if (n == count && array[i] != 0) {
				System.out.println(array[i] +(15*temp));
				return;
			} else if (array[i] != 0) {
				count++;
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
