import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] array = new int[n][m];
		int[][] cost = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				cost[0][0] = array[0][0];
				for (int j = 1; j < m; j++) {
					cost[i][j] = cost[i][j-1] + array[i][j];
				}
			}
			else {
				cost[i][0] = cost[i-1][0] + array[i][0];
				for (int j = 1; j < m; j++) {
					cost[i][j] = Math.min(cost[i-1][j], cost[i][j-1]) + array[i][j];
				}
			}
		}
		System.out.println(cost[n-1][m-1]);
    }
}
