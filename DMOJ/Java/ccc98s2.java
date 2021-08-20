import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		for (int i = 1000; i <= 9999; i++) {
			int sum = 1;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					sum+= j+i/j;
				}
			}
			if (sum == i) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		for (int i = 100; i <= 999; i++) {
			int sum = 0;
			sum+= Math.pow(i%10, 3);
			sum+= Math.pow((i/10)%10, 3);
			sum+= Math.pow((i/100)%10, 3);
			if (sum == i) {
				System.out.print(i + " ");
			}
		}
    }
}
