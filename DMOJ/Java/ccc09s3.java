import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayList<Integer> adj[] = new ArrayList[50];
		for (int i = 0; i < 50; i++) {
			adj[i] = new ArrayList();
		}
		adj[1].add(6);adj[2].add(6);adj[3].add(4);adj[3].add(5);adj[3].add(6);
        adj[3].add(15);adj[4].add(3);adj[4].add(5);adj[4].add(6);adj[5].add(3);
        adj[5].add(3);adj[5].add(4);adj[5].add(6);adj[6].add(1);adj[6].add(2);
        adj[6].add(3);adj[6].add(4);adj[6].add(5);adj[6].add(7);adj[7].add(6);
        adj[7].add(8);adj[8].add(7);adj[8].add(9);adj[9].add(8);adj[9].add(10);
        adj[9].add(12);adj[10].add(9);adj[10].add(11);adj[11].add(10);
        adj[11].add(12);adj[12].add(9);adj[12].add(11);adj[12].add(13);
        adj[13].add(12);adj[13].add(14);adj[13].add(15);adj[14].add(13);
        adj[15].add(3);adj[15].add(13);adj[16].add(17);adj[16].add(18);
        adj[17].add(16);adj[17].add(18);adj[18].add(16);adj[18].add(17);
        while (true) {
        	String str = sc.next();
        	if (str.equals("i")) {
        		int x = sc.nextInt(), y = sc.nextInt();
        		if (!adj[x].contains(y) || !adj[y].contains(x)) {
        			adj[x].add(y); adj[y].add(x);
        		}
        	}
        	else if (str.equals("d")) {
        		int x = sc.nextInt(), y = sc.nextInt();
        		adj[x].remove(adj[x].indexOf(y)); adj[y].remove(adj[y].indexOf(x));
        	}
        	else if (str.equals("n")) {
        		int x = sc.nextInt();
        		System.out.println(adj[x].size());
        	}
        	else if (str.equals("f") || str.equals("s")) {
        		int x = sc.nextInt(), y = 0;
        		if (str.equals("s")) {
        			y = sc.nextInt();
        		}
        		Queue<Integer> q = new LinkedList();
        		boolean[] vis = new boolean[50];
        		int[] dis = new int[50];
        		q.add(x); vis[x] = true; dis[x] = 0;
        		while (!q.isEmpty()) {
        			int cur = q.poll();
        			for (int nxt: adj[cur]) {
        				if (!vis[nxt]) {
        					q.add(nxt); vis[nxt] = true; dis[nxt] = dis[cur] + 1;
        				}
        			}
        		}
        		if (str.equals("f")) {
        			int count = 0;
        			for (int i = 0; i < 50; i++) {
        				if (dis[i] == 2) {
        					count++;
        				}
        			}
        			System.out.println(count);
        		}
        		else {
        			if (vis[y]) {
        				System.out.println(dis[y]);
        			}
        			else {
        				System.out.println("Not connected");
        			}
        		}
        	}
        	else {
        		break;
        	}
        }
	}
}
