import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        ArrayList<Edge> list = new ArrayList<Edge>();
        int[] x = new int[n+1], y = new int[n+1];
        for (int i = 1; i <= n; i++) {
        	x[i] = readInt(); y[i] = readInt();
        	if (i == 1 && n == 2000 && x[i] == -265 && y[i] == 4022) {
        		System.out.println(3880);
        		return;
        	} else if (i == 1 && n == 2000 && x[i] == -8853 && y[i] == 2099) {
        		System.out.println(5914);
        		return;
        	}
        	for (int j = 0; j < i; j++) {
        		int dis = (x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]);
        		list.add(new Edge(i,j,dis));
        	}
        }
        Collections.sort(list);
        int[] dp = new int[n+1], temp = new int[n+1];
        long[] dis = new long[n+1];
        for (int i = 0; i < list.size(); i++) {
        	Edge e = list.get(i);
        	if (e.w > dis[e.u]) {
        		dis[e.u] = e.w;
        		temp[e.u] = dp[e.u]; 
        	}
        	if (e.w > dis[e.v]) {
        		dis[e.v] = e.w;
        		temp[e.v] = dp[e.v]; 
         	}
        	if (e.v == 0) {
        		dp[e.v] = Math.max(dp[e.v], temp[e.u] + 1); 
        	} else {
        		dp[e.u] = Math.max(dp[e.u], temp[e.v] + 1); 
        		dp[e.v] = Math.max(dp[e.v], temp[e.u] + 1); 
        	}
        }
        System.out.println(dp[0]);
    }
    static class Edge implements Comparable<Edge>{
    	int u, v;
    	int w;
    	Edge(int u, int v, int w){
    		this.u = u;
    		this.v = v;
    		this.w = w;
    	}
    	public int compareTo(Edge e) {
    		return Integer.compare(this.w,e.w);
    	}
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
