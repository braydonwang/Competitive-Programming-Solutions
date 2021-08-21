import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			sum += array[i];
		}
		for (int i = 0; i <= Math.min(array[0], array[n-1]); i++) {
			if (solve(i,array,n)) {
				System.out.println("YES");
				System.out.println(sum/2);
				for (int j = 0; j < i; j++) {
					array[0]--; array[n-1]--;
					System.out.println(0 + " " + (n-1));
				}
				for (int j = 0; j < n-1; j++) {
					for (int a = 0; a < array[j]; a++) {
						array[j+1]--;
						System.out.println(j + " " + (j+1));
					}
				}
				return;
			}
		}
		System.out.println("NO");
	}
	static boolean solve(int k, int[] array, int n) {
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = array[i];
		}
		temp[0] -= k;
		temp[n-1] -= k;
		for (int i = 0; i < n-1; i++) {
			temp[i+1] -= temp[i];
			if (temp[i+1] < 0) {
				return false;
			}
		}
		if (temp[n-1] == 0) {
			return true;
		} else {
			return false;
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
