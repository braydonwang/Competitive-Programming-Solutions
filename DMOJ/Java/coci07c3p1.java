import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int[] array = new int[3];
		for (int i = 0; i < 3; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		if (array[1] - array[0] == array[2] - array[1]) {
			System.out.println(array[2] + (array[2]-array[1]));
		}
		else if (array[1] - array[0] > array[2] - array[1]) {
			System.out.println(array[0] + ((array[1] - array[0])/2));
		}
		else {
			System.out.println(array[1] + ((array[2] - array[1])/2));
		}
    }
}
