import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Pair[] array = new Pair[n];
		for (int i = 0; i < n; i++) {
			int t = readInt(), x = readInt();
			array[i] = new Pair(t,x);
		}
		Arrays.sort(array);
		double max = 0;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, Math.abs(((array[i].b - array[i-1].b)*1.0)) / (array[i].a - array[i-1].a));
		}
		System.out.println(max);
	}
	static class Pair implements Comparable<Pair>{
		int a,b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair p) {
			return this.a - p.a;
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
