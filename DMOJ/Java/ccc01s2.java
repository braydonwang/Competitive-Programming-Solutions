import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt(), y = sc.nextInt();
		int[][] array = new int[12][12];
		int r = 6, c = 6;
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		int limit = 1, d = 0, turn = 0, steps = 0;
		array[r][c] = x;
		for (int i = x+1; i <= y; i++) {
			if (steps < limit) {
				r += dir[d][0]; c += dir[d][1];
				array[r][c] = i; steps++;
			} else {
				d = (d+1)%4; turn++; steps = 0;
				if (turn == 2) {
					limit++;
					turn = 0;
				}
				i--;
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					System.out.print(array[i][j] + " ");
				}
			}
			System.out.println();
		}
    }
}
