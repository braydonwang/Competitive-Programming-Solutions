import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int j = readInt();
		int a = readInt();
		int[] array = new int[j];
		for (int i = 0; i < j; i++) {
			char ch = readCharacter();
			if (ch == 'S') {
				array[i] = 1;
			} else if (ch == 'M') {
				array[i] = 2;
			} else {
				array[i] = 3;
			}
		}
		int count = 0;
		for (int i = 0; i < a; i++) {
			char ch = readCharacter();
			int size = 0;
			if (ch == 'S') {
				size = 1;
			} else if (ch == 'M'){
				size = 2;
			} else {
				size = 3;
			}
			int num = readInt();
			if (array[num-1] >= size) {
				count++;
				array[num-1] = 0;
			}
		}
		System.out.println(count);
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
