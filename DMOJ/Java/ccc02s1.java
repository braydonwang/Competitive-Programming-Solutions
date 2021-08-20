import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int p = readInt(), g = readInt(), r = readInt(), o = readInt();
		int total = readInt();
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i <= total/p; i++) {
			for (int j = 0; j <= total/g; j++) {
				for (int k = 0; k <= total/r; k++) {
					for (int l = 0; l <= total/o; l++) {
						if (p*i + g*j + r*k + o*l == total) {
							count++;
							if (i + j + k + l < min) {
								min = i + j + k + l;
							}
							System.out.println("# of PINK is " + i + " # of GREEN is " + j + " # of RED is " + k + " # of ORANGE is " + l);
						}
					}
				}
			}
		}
		System.out.println("Total combinations is " + count + ".");
		System.out.println("Minimum number of tickets to print is " + min + ".");
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
}
