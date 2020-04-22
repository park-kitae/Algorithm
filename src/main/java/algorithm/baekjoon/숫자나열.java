package algorithm.baekjoon;

public class 숫자나열 {
    public static void main(String args[]){
        /*Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);*/
        solution(3,3);
    }

    private static void solution(int maxNumber, int limit){
        int[] printArr = new int[limit];
        for (int i = 1; i <= maxNumber; i++) {
            printArr[0] = i;
            loopNumber(printArr, limit);
            print(printArr);
        }
    }

    private static void loopNumber(int[] printArr, int limit){
        for (int j = 1; j <= limit; j++) {
            for (int i = 1; i <= limit; i++) {
                if(!dupleCheck(printArr, i)){
                    printArr[j] = i;
                    break;
                }
            }
        }
    }

    private static boolean dupleCheck(int[] printArr, int number){
        for (int i = 0; i < printArr.length; i++) {
            if(printArr[i] == number) return true;
        }
        return false;
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
