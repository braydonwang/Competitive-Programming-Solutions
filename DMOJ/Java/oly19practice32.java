import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		Triple[] array = new Triple[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Triple(readInt(),readInt(),i+1);
		}
		Arrays.sort(array);
		Triple[] temp = new Triple[k];
		for (int i = n-1; i >= n-k; i--) {
			temp[i-(n-k)] = new Triple(array[i].y,0,array[i].z);
		}
		Arrays.sort(temp);
		System.out.println(temp[k-1].z);
	}
	static class Triple implements Comparable<Triple>{
		int x, y, z;
		Triple(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public int compareTo(Triple p) {
			return this.x - p.x;
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
