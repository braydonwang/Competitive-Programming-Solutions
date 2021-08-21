import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static long mod = (long)998244353;
	static int maxn = 300002;
	static int[] pre;
	static long[][] p, dist;
	static long[] dis;
	static int[] h;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		p = new long[maxn][51];
		for(int i = 0; i <= 300001; i++){
	        p[i][0] = 1;
	        for(int j = 1; j <= 50; j++) {
	        	p[i][j] = (p[i][j-1]*i)%mod;
	        }
	    }
	    int n = readInt();
	    adj = new ArrayList[n+1];
	    for (int i = 0; i <= n; i++) {
	    	adj[i] = new ArrayList();
	    }
	    pre = new int[maxn];
	    dist = new long[maxn][51];
	    dis = new long[maxn];
	    h = new int[maxn];
	    dp = new int[maxn][22];
	    for(int i = 1; i <= n-1; i++){
	        int a = readInt(), b = readInt();
	        adj[a].add(b);
	        adj[b].add(a);
	    }
	    dfs(1, 0);
	    dfs2(1, 0);
	    dfs3(1, 0);
	    int q = readInt();
	    for(int i = 1; i <= q; i++){
	        int u = readInt(), v = readInt(), k = readInt();
	        int anc = lca(u, v);
	        long ans = ((dist[u][k]+dist[v][k]-(2*dist[pre[anc]][k])%mod+mod)%mod-p[(int) dis[anc]][k]+mod)%mod;
	        System.out.println(ans);
	    }
	}
	static void dfs(int cur, int par){
	    h[cur] = h[par]+1;
	    dp[cur][0] = par;
	    for(int i = 1; i < 20; i++){
	        dp[cur][i] = dp[dp[cur][i-1]][i-1];
	    }
	    for(int i : adj[cur]){
	        if(i != par)dfs(i, cur);
	    }
	}
	static int lca(int a, int b){
	    if(h[a] < h[b]) {
	    	a = a ^ b;
	    	b = a ^ b;
	    	a = a ^ b;
	    }
	    int dif = h[a]-h[b];
	    for(int i = 20; i >= 0; i--){
	        if(h[dp[a][i]] >= h[b]) {
	        	a = dp[a][i];
	        }
	    }
	    if(a == b) {
	    	return a;
	    }
	    for(int i = 19; i >= 0; i--){
	        if(dp[a][i] != dp[b][i]){
	            a = dp[a][i]; b = dp[b][i];
	        }
	    }
	    return dp[a][0];
	}

	static void dfs2(int cur, int par){
	    pre[cur] = par;
	    for(int i : adj[cur]){
	        if(i != par){
	            dis[i] = dis[cur]+1;
	            dfs2(i, cur);
	        }
	    }
	}
	static void dfs3(int cur, int par){
	    for(int i : adj[cur]){
	        if(i != par){
	            for(int j = 1; j <= 50; j++){
	                dist[i][j] = (dist[cur][j]+p[(int) (dis[cur]+1)][j])%mod;
	            }
	            dfs3(i, cur);
	        }
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
