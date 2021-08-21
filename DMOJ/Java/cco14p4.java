import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), p = readInt();
		Planet[] array = new Planet[n];
		int total = 0, count = 1;
		for (int i = 0; i < n; i++) {
			array[i] = new Planet(readInt(), readInt());
			if (i+1 == p) {
				total = array[i].a;
				array[i].a = 0;
			}
		}
		Arrays.sort(array);
		for (int i = 0; i < n; i++) {
			if (total - array[i].b >= 0 && array[i].a >= array[i].b) {
				total += (array[i].a - array[i].b);
				count++;
			}
		}
		System.out.println(total);
		System.out.println(count);
	}
	static class Planet implements Comparable<Planet>{
		int a, b;
		Planet(int a, int b){
			this.a = a;
			this.b = b;
		}
		public int compareTo(Planet p) {
			return this.b - p.b;
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
