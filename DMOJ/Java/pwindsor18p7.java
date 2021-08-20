import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Temp[] array = new Temp[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Temp(next());
		}
		Arrays.sort(array);
		String str = "";
		for (int i = n-1; i >= 0; i--) {
			str += array[i].str;
		}
		System.out.println(str);
	}
	static class Temp implements Comparable<Temp>{
		String str;
		Temp(String str){
			this.str = str;
		}
		public int compareTo(Temp t) {
			return (this.str + t.str).compareTo(t.str + this.str);
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
