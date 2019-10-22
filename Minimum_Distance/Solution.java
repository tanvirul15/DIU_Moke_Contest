/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minimum_Distance;

/**
 *
 * @author Tanvir
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        Map<Integer,Integer> mp=new TreeMap<>();
        int min_dis=Integer.MAX_VALUE;
        int l=a.length;
        
        for(int i=0;i<l;i++){
            if(mp.containsKey(a[i])){
                int ind=mp.get(a[i]);
                min_dis=Math.min(min_dis, (i-ind));
            }
            else mp.put(a[i], i);
        
        }
        
        

        return min_dis<Integer.MAX_VALUE?min_dis:-1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

