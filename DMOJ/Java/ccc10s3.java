import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int h;
	static int max = (int)1e6;
	public static void main(String[] args) throws IOException {
		h = readInt();
		int lo = 0, hi = 0;
		int[] array = new int[h];
		for (int i = 0; i < h; i++) {
			array[i] = readInt();
			hi = Math.max(hi, array[i]);
		}
		Arrays.sort(array);
		int[] newArray = new int[2*h];
		for (int i = 0; i < h; i++) {
			newArray[i] = array[i];
			newArray[i+h] = newArray[i] + max;
		}
		int k = readInt();
		int ans = Integer.MAX_VALUE;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (works(newArray,mid,k)) {
			    ans = Math.min(mid,ans);
				hi = mid-1;
			}
			else {
				lo = mid+1;
			}
		}
		System.out.println(ans);
	}
	static boolean works(int[] array, int mid, int k) {
		for (int i = 0; i < h; i++) {
			int range = array[i] + (mid*2);
			int count = 1;
			for (int j = i+1; j < i+h; j++) {
				if (array[j] > range) {
					count++;
					range = array[j] + (mid*2);
				}
			}
			if (count <= k) {
				return true;
			}
		}
		return false;
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
