import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int sum = 0;
		int x = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		ArrayList<Integer> arr2=new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr1.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			arr2.add(sc.nextInt());
		}
		if (x == 1) {
			Collections.sort(arr1);
			Collections.sort(arr2);
			for (int j = 0; j < n; j++) {
				if (arr1.get(j) > arr2.get(j)) {
					sum+= arr1.get(j);
				}
				else {
					sum+= arr2.get(j);
				}
			}
		}
		else {
			arr1.addAll(arr2);
			Collections.sort(arr1);
			for (int j = n; j < n*2; j++) {
				sum+= arr1.get(j);
			}
		}
		System.out.println(sum);
    }
}
