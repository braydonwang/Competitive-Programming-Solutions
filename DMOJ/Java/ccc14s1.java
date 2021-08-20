import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
	    int num = sc.nextInt(); int n = sc.nextInt();
	    ArrayList<Integer> list=new ArrayList<Integer>();
	    for (int i = 0; i < num; i++) {
	    	list.add(i+1);
	    }
	    for (int i = 0; i < n; i++) {
	    	ArrayList<Integer> temp=new ArrayList<Integer>();
	    	int x = sc.nextInt();
	    	for (int j = 1; j <= list.size(); j++) {
	    		if (j % x != 0) {
	    			temp.add(list.get(j-1));
	    		}
	    	}
	    	list = temp;
	    }
	    for (int i = 0; i < list.size(); i++) {
	    	System.out.println(list.get(i));
	    }
    }
}
