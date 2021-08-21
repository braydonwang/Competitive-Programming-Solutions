import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int[] array = new int[5];
		int[] a = {1,2,3,4,5};
		for (int i = 0; i < 5; i++) {
			array[i] = sc.nextInt();
		}
		while (true) {
			for (int i = 0; i < 4; i++) {
				if (array[i] > array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					for (int j = 0; j < 5; j++) {
						System.out.print(array[j] + " ");
					}
					System.out.println();
				}
			}
			if (Arrays.equals(array, a)) {
				break;
			}
		}
    }
}
