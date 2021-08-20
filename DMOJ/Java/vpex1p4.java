import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dis;
	static ArrayList<Edge> adj[];
	static int[] h;
	static int maxn = (int)1e5;
	static int logn = 18;
	static int[][] dp = new int[maxn+5][logn+2];
	public static void main(String[] args) throws IOException {
		int n = readInt(), d = readInt();
		h = new int[n+1];
		dis = new int[n+1];
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			adj[a].add(new Edge(b,c));
			adj[b].add(new Edge(a,c));
		}
		dfs(1,0);
		dfs2(1,0);
		long[][] pd = new long[d+1][2];
		int[][] array = new int[d+1][2];
		array[0][0] = array[0][1] = 1;
		for (int i = 1; i <= d; i++) {
			int x = readInt(), y = readInt();
			array[i][0] = x; array[i][1] = y;
			int pre0 = array[i-1][0], pre1 = array[i-1][1];
			int disx0 = dis[pre0] + dis[x] - 2*dis[lca(pre0,x)];
			int disx1 = dis[pre1] + dis[x] - 2*dis[lca(pre1,x)];
			int disy0 = dis[pre0] + dis[y] - 2*dis[lca(pre0,y)];
			int disy1 = dis[pre1] + dis[y] - 2*dis[lca(pre1,y)];
			int disxy = dis[x] + dis[y] - 2*dis[lca(x,y)];
			pd[i][0] = Math.min(pd[i-1][0] + disy0, pd[i-1][1] + disy1) + disxy;
			pd[i][1] = Math.min(pd[i-1][0] + disx0, pd[i-1][1] + disx1) + disxy;
			//System.out.println(disy0 + " " + disy1 + " " + disxy);
			//System.out.println(pd[i][0] + " " + pd[i][1]);
		}
		//System.out.println(h[2] + " " + h[5]);
		System.out.println(Math.min(pd[d][0], pd[d][1]));
	}
	static void dfs(int cur, int par){
	    h[cur] = h[par]+1;
	    dp[cur][0] = par;
	    for(int i = 1; i < logn; i++){
	        dp[cur][i] = dp[dp[cur][i-1]][i-1];
	    }
	    for(Edge i : adj[cur]){
	        if(i.v != par) {
	        	dfs(i.v, cur);
	        }
	    }
	}
	static int lca(int a, int b){
	    if(h[a] < h[b]) {
	    	int c = b;
	    	b = a;
	    	a = c;
	    }
	    int dif = h[a]-h[b];
	    for(int i = 0; i < logn; i++){
	        if((dif&(1<<i)) != 0) {
	        	a = dp[a][i];
	        }
	    }
	    if(a == b) {
	    	return a;
	    }
	    for(int i = logn-1; i >= 0; i--){
	        if(dp[a][i] != dp[b][i]){
	            a = dp[a][i]; b = dp[b][i];
	        }
	    }
	    return dp[a][0];
	}
	static void dfs2(int v, int par) {
		for (Edge nxt: adj[v]) {
			if (nxt.v != par) {
				dis[nxt.v] = dis[v] + nxt.w;
				dfs2(nxt.v,v);
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
