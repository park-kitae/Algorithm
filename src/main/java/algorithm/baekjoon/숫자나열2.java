package algorithm.baekjoon;

public class 숫자나열2 {
    public static void main(String args[]){
        /*Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);*/
        solution(4,4);
    }

    private static void solution(int maxNumber, int limit){
        int[][] printArr = new int[maxNumber * limit][limit];
        for (int i = 0; i < maxNumber; i++) {
            //printArr[i] = print
        }
    }

    private static void print(int[] printArr){
        for (int i = 0; i < printArr.length; i++) {
            if(i+1 == printArr.length)
                System.out.println(printArr[i]);
            else
                System.out.print(printArr[i] + " ");
        }
    }

}
