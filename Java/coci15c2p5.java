import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] bit;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		bit = new int[n+6];
		long[] a = new long[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		int p = readInt();
		//keep a sorted array to sort values for coordinate compression
		Pair[] sort = new Pair[n+1];
		for (int i = 1; i <= n; i++) {
			//decrease each value in the array by p to only find sums that are >= 0
			a[i] -= p;
			a[i] += a[i-1];
			sort[i] = new Pair(i,a[i]);
		}
		//must include 0 in the array for subarrays of pre[k] - pre[0]
		sort[0] = new Pair(-1,0);
		Arrays.sort(sort);
		int pos = 0;
		long ans = 0;
		for (int i = 0; i <= n; i++) {
			//for all values in the sorted array that are less than the current sort[i].val, add it to the bit by its index
			while (pos < i) {
				update(sort[pos].ind,1);
				pos++;
			}
			//only consider pre values in the bit that have an index less than the current one, which means that it is a valid subarray
			ans += query(sort[i].ind-1);
		}
		System.out.println(ans);
	}
	static class Pair implements Comparable<Pair>{
		int ind;
		long val;
		Pair(int ind, long val){
			this.ind = ind;
			this.val = val;
		}
		public int compareTo(Pair p) {
			if (this.val < p.val){
			    return -1;
			} else if (this.val == p.val) {
			    return 0;
			} else {
			    return 1;
			}
		}
	}
	static void update(int x, int v) {
		x += 5;
		for (int i = x; i <= n+5; i += i&-i) {
			bit[i] += v;
		}
	}
	static long query(int x) {
		x += 5;
		long total = 0;
		for (int i = x; i > 0; i -= i&-i) {
			total += bit[i];
		}
		return total;
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
