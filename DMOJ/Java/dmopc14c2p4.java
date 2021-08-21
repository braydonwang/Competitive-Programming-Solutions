import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int l,r;
        int[] trees = new int[n+1];
        
        for(int i = 1; i <= n; i ++){
            trees[i] = input.nextInt();
        }
        int q = input.nextInt();
        int[][] queries = new int[q][2];
        for(int i = 0; i < q; i ++){
                queries[i][0] = input.nextInt()+1;
                queries[i][1] = input.nextInt()+1;
            
        }
        
        
        int[] psa = new int[n+1];
        psa[0] = trees[0];
        for(int i = 1; i <= n; i ++){
            psa[i] = psa[i-1] + trees[i];
        }
        
        
        for(int i = 0; i < queries.length; i++){
            l = queries[i][0];
            r = queries[i][1];
            
            System.out.println(psa[r] - psa[l-1]);
            
            
        }
        
        
        
    }
}
