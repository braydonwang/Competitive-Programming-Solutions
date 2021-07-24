import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] visited;
	static int n;
	static ArrayList<Edge> adj[];
	static boolean[] vis;
	static int max1, far1, max2, far2;
    static Edge[] pre;
    static int dia = 0;
	public static void main(String[] args) throws IOException {
		n = readInt(); int m = readInt(), l = readInt();
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt(), t = readInt();
			adj[a].add(new Edge(b,t)); adj[b].add(new Edge(a,t));
		}
		vis = new boolean[n+1];
		int[] rad = new int[n+1];
		pre = new Edge[n];
		int ind = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				max1 = 0; max2 = 0;
				far1 = i; far2 = i;
				dfs(i,-1,0);
				pre[far1] = new Edge(-1,-1);
				dfs2(far1,-1,0);
				int count = 0, radi = Integer.MAX_VALUE;
		        while (far2 != -1) {
		        	radi = Math.min(radi, Math.max(count, max2-count));
		        	count += pre[far2].w;
		        	far2 = pre[far2].v;
		        }
				rad[ind] = radi; ind++;
			}
		}
		Arrays.sort(rad);
		//System.out.println(Arrays.toString(rad));
		int x = 0, y = 0;
		if (ind >= 2) {
			x = rad[n] + rad[n-1] + l;
		}
		if (ind >= 3) {
			y = rad[n-1] + rad[n-2] + 2*l;
		}
		System.out.println(Math.max(dia,Math.max(x,y)));
	}
	static void dfs2(int v, int par, int dis) {
    	if (dis > max2) {
    		max2 = dis; far2 = v;
    		dia = Math.max(dia, max2);
    	}
    	for (Edge nxt: adj[v]) {
    		if (nxt.v != par) {
    			pre[nxt.v] = new Edge(v,nxt.w);
    			dfs2(nxt.v,v,dis+nxt.w);
    		}
    	}
    }
    static void dfs(int v, int par, int dis) {
    	vis[v] = true;
    	if (dis > max1) {
    		max1 = dis; far1 = v;
    		dia = Math.max(dia, max1);
    	}
    	for (Edge nxt: adj[v]) {
    		if (nxt.v != par) {
    			dfs(nxt.v,v,dis+nxt.w);
    		}
    	}
    }
	static class Edge{
		int v, w;
		Edge(int v, int w){
			this.v = v;
			this.w = w;
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
