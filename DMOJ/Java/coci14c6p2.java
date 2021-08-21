import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		String[] array = new String[t];
		for (int i = 0; i < t; i++) {
			array[i] = next();
		}
		int[] num = new int[7];
		//o, v, n, ov, on, vn, ovn
		int m = readInt();
		for (int i = 0; i < m; i++) {
			String str = next();
			if (str.indexOf('O') != -1 && str.indexOf('V') != -1 && str.indexOf('N') != -1) {
				num[6]++;
			} else if (str.indexOf('O') != -1 && str.indexOf('V') != -1) {
				num[3]++;
			} else if (str.indexOf('V') != -1 && str.indexOf('N') != -1) {
				num[5]++;
			} else if (str.indexOf('O') != -1 && str.indexOf('N') != -1) {
				num[4]++;
			} else if (str.indexOf('O') != -1) {
				num[0]++;
			} else if (str.indexOf('V') != -1) {
				num[1]++;
			} else {
				num[2]++;
			}
		}
		//System.out.println(Arrays.toString(num));
		for (int i = 0; i < t; i++) {
			int temp = array[i].indexOf('-');
			int o = Integer.parseInt(array[i].substring(0,temp));
			int temp2 = array[i].indexOf('-',temp+1);
			int v = Integer.parseInt(array[i].substring(temp+1,temp2));
			int n = Integer.parseInt(array[i].substring(temp2+1));
			boolean good = false;
			for (int a = 0; a <= num[3]; a++) { //give a o's, num[4] - a v's
				for (int b = 0; b <= num[4]; b++) { //give b n's, num[5] - b o's
					for (int c = 0; c <= num[5]; c++) {//give c v's, num[6] - c n's
						int x = Math.max(0, o - num[0] - a - (num[4] - b));
						int y = Math.max(0, v - num[1] - c - (num[3] - a));
						int z = Math.max(0, n - num[2] - b - (num[5] - c));
						if (x + y + z <= num[6]) {
							//System.out.println(x + " " +y + " " + z);
							System.out.println("DA");
							good = true;
							break;
						}
					}
					if (good) break;
				}
				if (good) break;
			}
			if (!good) {
				System.out.println("NE");
			}
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
