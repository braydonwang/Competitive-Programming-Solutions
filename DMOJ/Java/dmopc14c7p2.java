import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); int max = -1; int min = 100000; String str = "";
		int[] array = new int[n]; boolean increase = false;
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
			max = Math.max(max,array[i]);
			min = Math.min(min,array[i]);
		}
		for (int i = 0; i < n-1; i++) {
			if (array[i] == min) {
				increase = true;
			}
			else if (increase && array[i] == max) {
				increase = false;
			}
			else if (!increase && array[i] == max) {
				System.out.println("unknown");
				return;
			}
			else if (increase && array[i] > array[i+1]) {
				System.out.println("unknown");
				return;
			}
		}
		System.out.println(max-min);
    }
}
