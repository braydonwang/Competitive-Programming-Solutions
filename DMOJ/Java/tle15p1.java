import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), p = readInt();
		Pair[] array = new Pair[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(next(),0);
		}
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < n; j++) {
				array[j].x += readInt();
			}
		}
		Arrays.sort(array);
		for (int i = 3; i < n+3; i++) {
			System.out.println(i + ". " + array[i-3].str);
		}
	}
	static class Pair implements Comparable<Pair>{
		String str;
		int x;
		Pair(String str, int x){
			this.str = str;
			this.x = x;
		}
		public int compareTo(Pair p) {
			return p.x - this.x;
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
