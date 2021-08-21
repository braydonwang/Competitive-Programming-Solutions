import java.util.*;
import java.io.*;

public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = readInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = readInt();
		}
		int count = 0;
		boolean war = false;
		for (int i = 0; i < n; i++) {
			if (arr1[i] == arr2[i] && !war) {
				war = true;
				count++;
			} else if (arr1[i] != arr2[i]){
				war = false;
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
