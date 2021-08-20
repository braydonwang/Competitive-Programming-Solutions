import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int[][] array = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += array[0][i];
		}
		for (int i = 0; i < 4; i++) {
			int total = 0;
			for (int j = 0; j < 4; j++) {
				total += array[i][j];
			}
			if (total != sum) {
				System.out.println("not magic");
				return;
			}
		}
		for (int i = 0; i < 4; i++) {
			int total = 0;
			for (int j = 0; j < 4; j++) {
				total += array[j][i];
			}
			if (total != sum) {
				System.out.println("not magic");
				return;
			}
		}
		System.out.println("magic");
    }
}
