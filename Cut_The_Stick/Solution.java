/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cut_The_Stick;

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

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> ar=new ArrayList<>();
        int count=0;
        int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            min=Math.min(min, arr[i]);
            if(arr[i]>0)count++;
            
            }
        System.out.println("Min Value: "+min);
        if(count!=0)ar.add(count);
        
        
        do{
            count=0;
            min2=Integer.MAX_VALUE;
            
            for(int i=0;i<arr.length;i++){
                if(arr[i]>0)arr[i]-=min;
                if(arr[i]>0){
                    count++;
                    min2=Math.min(min2, arr[i]);
                }
            
            }
            min=min2;
            if(count!=0)ar.add(count);
            System.out.println("Count: "+count+"  Min: "+min);
        
        
        
            
        }while(count!=0);

        int out_ar[]=new int[ar.size()];
        for(int i=0;i<ar.size();i++){
            out_ar[i]=ar.get(i);
        }
        return out_ar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
