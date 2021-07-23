import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] bit;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		int k = readInt();
		bit = new int[n+1][n+1];
		int[][] array = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				array[i][j] = readInt();
			}
		}
		long ans = 0;
		for (int i = n; i >= 1; i--) {
			for (int j = i, l = 1; j <= n; j++, l++) {
				update(j,l,array[j][l]);
			}
			for (int j = i, l = 1; j <= n; j++, l++) {
				if (j + k - 1 <= n) {
					ans += query(j+k-1,l);
				}
			}
		}
		System.out.println(ans);
	}
	static void update(int x, int y, int v) {
		y = n - y + 1;
		for (int i = x; i <= n; i += i&-i) {
			for (int j = y; j <= n; j += j&-j) {
				bit[i][j] = Math.max(bit[i][j], v);
			}
		}
	}
	static long query(int x, int y) {
		y = n - y + 1;
		long total = 0;
		for (int i = x; i > 0; i -= i&-i) {
			for (int j = y; j > 0; j -= j&-j) {
				total = Math.max(total, bit[i][j]);
			}
		}
		return total;
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	private static final int BUFFER_SIZE = 1 << 16;
	private static final InputStream in = System.in;
	private static final byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	private static void fillBuffer() throws IOException {
		bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}
	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
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
