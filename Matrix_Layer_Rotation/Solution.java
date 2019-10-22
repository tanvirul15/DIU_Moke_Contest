/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix_Layer_Rotation;

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
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int h = matrix.size();
        int l = matrix.get(0).size();
        int k = Math.min(l, h) / 2;

        for (int count = 0; count < r; count++) {

            for (int i = 0; i < k; i++) {
                int x, y;
                x = i;
                y = i;
                int temp = matrix.get(i).get(i);

                while (y < l - i - 1) {
                    matrix.get(x).set(y, matrix.get(x).get(y + 1));
                    y++;
                }
                while (x < h - 1 - i) {
                    matrix.get(x).set(y, matrix.get(x + 1).get(y));
                    x++;
                }
                while (y > i) {
                    matrix.get(x).set(y, matrix.get(x).get(y - 1));
                    y--;

                }
                while (x > i + 1) {
                    matrix.get(x).set(y, matrix.get(x - 1).get(y));
                    x--;

                }
                matrix.get(x).set(y, temp);

                

            }

        }
        StringBuilder sb=new StringBuilder();
                    for (List<Integer> li : matrix) {
                    for(int temp2:li){
                        sb.append(temp2+" ");
                    }
                    sb.append(System.getProperty("line.separator"));

                }
                    System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
