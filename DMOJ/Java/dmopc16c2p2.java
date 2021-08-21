import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			int x = sc.nextInt();
			for (int j = 0; j < k-1; j++) {
				int a = sc.nextInt();
				if (find(x) != find(a)) {
					union(x,a);
				}
			}
		}
		int rep = find(1);
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (find(i) == rep) {
				count++;
				list.add(i);
			}
		}
		System.out.println(count);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	public static int find(int v) {
		if (parent[v] == v) {
			return v;
		}
		else {
			int result = find(parent[v]);
			parent[v] = result;
			return result;
		}
	}
	public static void union(int a, int b) {
		int arep = find(a);
		int brep = find(b);
		parent[arep] = brep;
    }
}
