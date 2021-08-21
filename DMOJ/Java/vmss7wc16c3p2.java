import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int houses = sc.nextInt(); int roads = sc.nextInt();
		int a = sc.nextInt(); int b = sc.nextInt();
		List<Integer> adj[] = new ArrayList[houses+1];
		for (int i = 0; i <= houses; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < roads; i++) {
			int x = sc.nextInt(); int y = sc.nextInt();
			adj[x].add(y); adj[y].add(x);
		}
		Queue<Integer> Q = new LinkedList();
		boolean vis[] = new boolean[houses+1];
		Q.add(a); vis[a] = true;
		while (!Q.isEmpty()) {
			int cur = Q.poll();
			for (int nxt: adj[cur]) {
				if(!vis[nxt]) {
					Q.add(nxt); vis[nxt] = true;
				}
			}
		}
		if (vis[b]) {
			System.out.println("GO SHAHIR!");
		}
		else {
			System.out.println("NO SHAHIR!");
		}
    }
}
