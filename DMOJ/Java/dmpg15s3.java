import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int sum = 0;
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
			sum += array[i];
		}
		int x = sc.nextInt();
		int[] position = new int[x];
		int[] decrease = new int[x];
		for (int i = 0; i < x; i++) {
			position[i] = sc.nextInt();
			decrease[i] = sc.nextInt();
		}
		for (int i = 0; i < x; i++) {
			if (array[position[i]-1] < array[position[i]]) {
				if (decrease[i] > array[position[i]-1]) {
					sum-= array[position[i]-1];
				}
				else {
					sum-= decrease[i];
				}
			}
			else {
				if (decrease[i] > array[position[i]]) {
					sum-= array[position[i]];
				}
				else {
					sum-= decrease[i];
				}
			}
		}
		System.out.println(sum);
    }
}
