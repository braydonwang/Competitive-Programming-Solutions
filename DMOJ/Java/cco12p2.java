import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CCO_12_P2_The_Hungary_Games {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
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
    static String readLine () throws IOException {
        return br.readLine().trim();
    }

    public static class Node implements Comparable<Node>{
        int cv;
        int cw;

        Node(int v, int w){
            cv = v;
            cw = w;
        }

        @Override
        public int compareTo(Node o) {
            return cw-o.cw;
        }
    }

    public static class Edge{
        int v;
        int w;
        Edge(int v0, int w0){
            v = v0;
            w = w0;
        }
    }

    public static int[] dijstra(ArrayList<Edge>[] e , int bv){
        int[] dis = new int[n+1];
        for(int i = 0 ; i < dis.length; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> l = new PriorityQueue<>();
        l.add(new Node(bv,0));
        dis[bv] = 0;
        while(!l.isEmpty()){
            Node t = l.poll();
            int cv = t.cv;
            int cw = t.cw;
            for(Edge next : e[cv]){
                int ev = next.v;
                int ew = next.w;
                if(dis[ev] > cw + ew){
                    dis[ev] = cw + ew;
                    l.add(new Node(ev, cw + ew));
                }
            }
        }
        return dis;
    }
    static int n, m;

    public static void main(String[] args) throws Exception{
        n = readInt(); m = readInt();
        ArrayList<Edge>[] e = new ArrayList[n+1];
        ArrayList<Edge>[] re = new ArrayList[n+1];
        for(int i = 0 ; i < e.length; i++){
            e[i] = new ArrayList<Edge>();
            re[i] = new ArrayList<Edge>();
        }
        for(int i = 0 ; i< m ; i++){
            int a = readInt(); int b = readInt(); int x = readInt();
            e[a].add(new Edge(b,x));
            re[b].add(new Edge(a,x));
        }
        int[] dis1 = dijstra(e,1);
        int[] dis2 = dijstra(re, n);
        
        if(dis1[n] == Integer.MAX_VALUE){
            System.out.println(-1); return;
        }

        int ans = Integer.MAX_VALUE;
        for(int u = 1 ; u<= n; u++){
            for(Edge t : e[u]){
                int v = t.v; int w = t.w;
                if(dis1[u]!=Integer.MAX_VALUE && dis2[v]!=Integer.MAX_VALUE && dis1[u] + w + dis2[v] > dis1[n]){
                    ans = Math.min(ans, dis1[u] + w + dis2[v]);
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }


    }
}
