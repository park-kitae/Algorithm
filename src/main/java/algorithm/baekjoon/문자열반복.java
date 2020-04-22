package algorithm.baekjoon;

import java.util.Scanner;

public class 문자열반복 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        int[] val = new int[a];
        String[] str = new String[a];
        int index = 0;
        while (sc.hasNext()){
            val[index] = sc.nextInt();
            str[index] = sc.next();
            index++;
        }

        for (int i = 0; i < a; i++) {
            System.out.println(solution(val[i], str[i]));
        }
    }

    public static String solution(int val, String str){
        String[] arr = str.split("");
        String returnStr = "";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < val; j++) {
                returnStr += arr[i];
            }
        }
        return returnStr;
    }
}