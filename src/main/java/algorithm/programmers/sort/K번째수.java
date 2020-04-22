package algorithm.programmers.sort;

import java.util.Arrays;

public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int startIndex = commands[i][0] -1;
            int endIndex = commands[i][1] -1;
            int pickNumber = commands[i][2] -1;
            int[] slice = sliceArray(array, startIndex, endIndex);
            answer[i] = pickLocation(slice, pickNumber);
        }

        return answer;
    }

    private static int[] sliceArray(int[] array, int startIndex, int endIndex){
        int returnLength = endIndex - startIndex + 1;
        int[] returnArray = new int[returnLength];
        System.arraycopy(array, startIndex, returnArray, 0, returnLength);
        return returnArray;
    }

    private static int pickLocation(int[] array, int pickNumber){
        int[] returnArr = Arrays.stream(array).sorted().toArray();
        return returnArr[pickNumber];
    }
}
