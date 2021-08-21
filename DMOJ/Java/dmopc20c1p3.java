import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[] array = new long[n+2];
		long max = Long.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
			max = Math.max(array[i],max);
		}
		boolean increase = true;
		array[0] = Long.MIN_VALUE; array[n+1] = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (array[i] == max) {
				break;
			}
			if (array[i] >= array[i-1]) {
				continue;
			} else {
				sum += array[i-1] - array[i];
				array[i] = array[i-1];
			}
		}
		for (int i = n; i >= 1; i--) {
			if (array[i] == max) {
				break;
			}
			if (array[i] >= array[i+1]) {
				continue;
			} else {
				sum += array[i+1] - array[i];
				array[i] = array[i+1];
			}
		}
		//System.out.println(Arrays.toString(array));
		System.out.println(sum);
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
