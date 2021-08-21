import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), b = readInt();
		Pair[] array = new Pair[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(readInt(),readInt());
		}
		Arrays.sort(array);
		int max = 0, total = 0, count = 0;
		int i;
		for (i = 0; i < n; i++) {
			if (total + array[i].p + array[i].s > b) {
				break;
			}
			total += array[i].p + array[i].s;
			max = Math.max(max,array[i].p);
			count++;
		}
		total -= max/2;
		for (; i < n; i++) {
			if (total + array[i].p + array[i].s > b) {
				break;
			}
			total += array[i].p + array[i].s;
			count++;
		}
		System.out.println(count);
	}
	static class Pair implements Comparable<Pair>{
		int p, s;
		Pair (int p, int s){
			this.p = p;
			this.s = s;
		}
		public int compareTo(Pair x) {
			return (this.p + this.s) - (x.p + x.s);
		}
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
