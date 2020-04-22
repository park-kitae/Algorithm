package algorithm.baekjoon;

import java.util.Scanner;

public class 재귀함수 {

    private static int a;
    private static int val;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        val = 1;
        solution();
    }

    public static void solution(){
        if(a == 0){
            System.out.print(val);
        }else{
            val *= a;
            a--;
            solution();
        }
    }
}
