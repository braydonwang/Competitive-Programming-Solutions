import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[] array = new int[5];
		int[] array2 = new int[5];
		for (int i = 0; i < 5; i++) {
			array[i] = readInt();
		}
		for (int i = 0; i < 5; i++) {
			array2[i] = readInt();
		}
		Arrays.sort(array);
		Arrays.sort(array2);
		int total = array[array.length-1] + array[array.length-2] + array[array.length-3] + array[array.length-4];
		int total2 = array2[array.length-1] + array2[array.length-2] + array2[array.length-3] + array2[array.length-4];
		System.out.println(Math.max(total, total2));
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
