import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] tree = new int[65537][51];
	static int f, n, d;
	static int[] c, v;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		f = readInt(); n = readInt(); d = readInt();
		for (int i = 0; i < 65537; i++) {
			Arrays.fill(tree[i], -1);
			tree[i][0] = 0;
		}
		c = new int[n+1]; v = new int[n+1];
		for (int i = 1; i <= n; i++) {
			c[i] = readInt(); v[i] = readInt();
		}
		build(1,1,n);
		for (int i = 0; i < d; i++) {
			int a = readInt(), b = readInt(), x = readInt(), y = readInt();
			update(1,1,n,a,b);
			ans = new int[51];
			query(1,1,n,x,y);
			int max = 0;
			for (int j = 1; j <= f; j++) {
				max = Math.max(max,ans[j]);
			}
			//System.out.println(Arrays.toString(ans));
			pw.println(max);
		}
		pw.close();
	}
	static void push2(int[] a1, int[] a2) {
		for (int i = 50; i >= 1; i--) {
			for (int j = 0; j <= i; j++) {
				if (a1[i-j] != -1 && a2[j] != -1) {
					a1[i] = Math.max(a1[i], a1[i-j] + a2[j]);
				}
			}
		}
	}
	static void query(int pos, int l, int r, int ll, int rr) {
		if (l > rr || r < ll) {
			return;
		} else if (ll <= l && r <= rr) {
			push2(ans,tree[pos]);
			return;
		}
		int mid = (l + r) / 2;
		if (pos * 2 >= 65537){
		    return;
		}
		query(pos*2,l,mid,ll,rr); query(pos*2+1,mid+1,r,ll,rr);
	}
	static void update(int pos, int l, int r, int x, int v) {
		if (r < x || l > x) {
			return;
		} else if (l == x && r == x) {
			int num = tree[pos][c[l]];
			tree[pos][c[l]] = 0;
			tree[pos][v] = num;
			c[l] = v;
			return;
		}
		int mid = (l + r) / 2;
		if (pos * 2 >= 65537){
		    return;
		}
		update(pos*2,l,mid,x,v); update(pos*2+1,mid+1,r,x,v);
		push(pos);
	}
	static void push(int pos) {
		for (int i = 50; i >= 1; i--) {
			tree[pos][i] = -1;
			for (int j = 0; j <= i; j++) {
				if (tree[pos*2][i-j] != -1 && tree[pos*2+1][j] != -1) {
					tree[pos][i] = Math.max(tree[pos][i], tree[pos*2][i-j] + tree[pos*2+1][j]);
				}
			}
		}
	}
	static void build(int pos, int l, int r) {
		if (l == r) {
			tree[pos][c[l]] = v[l];
			return;
		}
		int mid = (l + r) / 2;
		if (pos * 2 >= 65537){
		    return;
		}
		build(pos*2,l,mid); build(pos*2+1,mid+1,r);
		push(pos);
	}
	private static final int BUFFER_SIZE = 1 << 16;
	private static final InputStream in = System.in;
	private static final byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;

	public static String read() throws IOException {
		byte[] ret = new byte[1024];
		int idx = 0;
		byte c = Read();
		while (c <= ' ') {
			c = Read();
		}
		do {
			ret[idx++] = c;
			c = Read();
		} while (c != -1 && c != ' ' && c != '\n' && c != '\r');
		return new String(ret, 0, idx);
	}

	public static String readLine() throws IOException {
		final StringBuilder sb = new StringBuilder(1024);
		byte c = Read();
		while (c == '\n' || c == '\r') {
			c = Read();
		}
		do {
			sb.append((char) c);
			c = Read();
		} while (c != -1 && c != '\n' && c != '\r');
		return sb.toString();
	}

	public static char readChar() throws IOException {
		byte c = Read();
		while (Character.isWhitespace(c)) {
			c = Read();
		}
		return (char) c;
	}

	private static char[] readCharArray(final int chars) throws IOException {
		final char[] arr = new char[chars];
		for (int i = 0; i < chars; i++) {
			arr[i] = readChar();
		}
		return arr;
	}

	public static java.math.BigInteger readBigInteger() throws IOException {
		return new java.math.BigInteger(read());
	}

	public static java.math.BigDecimal readBigDecimal() throws IOException {
		return new java.math.BigDecimal(read());
	}

	public static byte readByte() throws IOException {
		byte ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = (byte) (ret * 10 + c - '0');
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return (byte) -ret;
		return ret;
	}

	public static byte[] readByteArray(final int numbers) throws IOException {
		final byte[] arr = new byte[numbers];
		for (int i = 0; i < numbers; i++) {
			arr[i] = readByte();
		}
		return arr;
	}

	public static short readShort() throws IOException {
		short ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = (short) (ret * 10 + c - '0');
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return (short) -ret;
		return ret;
	}

	public static short[] readShortArray(final int numbers) throws IOException {
		final short[] arr = new short[numbers];
		for (int i = 0; i < numbers; i++) {
			arr[i] = readShort();
		}
		return arr;
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

	public static int[] readIntArray(final int numbers) throws IOException {
		final int[] arr = new int[numbers];
		for (int i = 0; i < numbers; i++) {
			arr[i] = readInt();
		}
		return arr;
	}

	public static long readLong() throws IOException {
		long ret = 0;
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

	public static long[] readLongArray(final int numbers) throws IOException {
		final long[] arr = new long[numbers];
		for (int i = 0; i < numbers; i++) {
			arr[i] = readLong();
		}
		return arr;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}
		if (neg)
			return -ret;
		return ret;
	}

	public static double[] readDoubleArray(final int numbers) throws IOException {
		final double[] arr = new double[numbers];
		for (int i = 0; i < numbers; i++) {
			arr[i] = readDouble();
		}
		return arr;
	}

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
}
