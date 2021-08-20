import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = readLine();
		String str2 = readLine();
		String[] arr1 = str.split(" ");
		String[] arr2 = str2.split(" ");
		for (int i = 0; i < n; i++) {
			if (arr1[i].equals(arr2[i])) {
				System.out.println("bad");
				return;
			} else {
				String first = arr1[i];
				String second = arr2[i];
				for (int j = 0; j < n; j++) {
					if ((arr1[j].equals(second) && !arr2[j].equals(first)) || (!arr1[j].contentEquals(second) && arr2[j].contentEquals(first))) {
						System.out.println("bad");
						return;
					}
				}
			}
		}
		System.out.println("good");
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
