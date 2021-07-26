import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> adj[];
    static boolean[] vis, g;
    static int edge;
    static int max, min;
    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt(), f = readInt();
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
        	adj[i] = new ArrayList();
        }
        g = new boolean[n+1];
        for (int i = 0; i < k; i++) {
        	g[readInt()] = true;
        }
        for (int i = 0; i < n-1; i++) {
        	int a = readInt(), b = readInt();
        	adj[a].add(b); adj[b].add(a);
        }
        vis = new boolean[n+1];
        min = Integer.MAX_VALUE;
        dfs(1,0);
        dfs2(1,0,0);
        dfs3(f,0,0);
        //System.out.println(Arrays.toString(vis));
        //System.out.println(max + " " + min);
        System.out.println(Math.min(2*(edge-1)-max, edge-1+min));
    }
    static void dfs3(int v, int par, int dis) {
    	if (vis[v]) {
    		min = Math.min(min, dis);
    	}
    	for (int nxt: adj[v]) {
    		if (nxt != par) {
    			dfs3(nxt,v,dis+1);
    		}
    	}
    }
    static void dfs2(int v, int par, int dis) {
    	if (dis > max) {
    		max = dis;
    	}
    	for (int nxt: adj[v]) {
    		if (nxt != par && vis[nxt]) {
    			dfs2(nxt,v,dis+1);
    		}
    	}
    }
    static boolean dfs(int v, int par) {
    	vis[v] = g[v];
    	for (int nxt: adj[v]) {
    		if (nxt != par) {
    			vis[v] |= dfs(nxt,v);
    		}
    	}
    	if (vis[v]) {
    		edge++;
    	}
    	return vis[v];
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
