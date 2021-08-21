import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), T = readInt();
        List <Edge> adj[] = new ArrayList[N+1];
        int[][] dis = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList();
        for (int i = 0; i < M; i++) {
            int s = readInt(), e = readInt(), h = readInt();
            adj[s].add(new Edge(e,h));
        }
        for (int i = 1; i <= N; i++){
            PriorityQueue <Edge> q = new PriorityQueue();
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0; q.add(new Edge(i,0));
            while (!q.isEmpty()) {
                Edge cur = q.poll();
                if (cur.w > dis[i][cur.v]) continue;
                for (Edge e: adj[cur.v]) {
                    if (dis[i][e.v] > Math.max(dis[i][cur.v],e.w)) {
                        dis[i][e.v] = Math.max(dis[i][cur.v],e.w);
                        q.add(new Edge(e.v, dis[i][e.v]));
                    }
                }
            }
        }
        for (int k = 0; k < T; k++) {
            int strt = readInt();
            int end = readInt();
            if (dis[strt][end] == Integer.MAX_VALUE){
                System.out.println(-1);
            } else {
                System.out.println(dis[strt][end]);
            }
        }
    }
    static class Edge implements Comparable<Edge>{
        int v, w;
        Edge(int v0, int w0) {v = v0; w = w0;}
        public int compareTo(Edge x) {return (Integer.compare(w, x.w));}
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
