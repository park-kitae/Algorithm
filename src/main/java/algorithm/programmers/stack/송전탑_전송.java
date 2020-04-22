package algorithm.programmers.stack;

import java.util.Arrays;

public class 송전탑_전송 {
    public static void main(String[] args) {
        int[] item = {6,9,5,7,4};
        Arrays.stream(solution(item)).forEach(System.out::println);
    }

    public static int[] solution(int[] heights) {
        int top_count = heights.length;
        int[] answer = new int[top_count];

        for (int i = top_count -1; i >= 0; i--) {
            int top_height = heights[i];
            for (int j = i-1; j >= 0; j--) {
                int select_height = heights[j];
                if(select_height > top_height){
                    answer[i] = j+1;
                    break;
                }

                if(j==0){
                    answer[i] = 0;
                }
            }
        }

        return answer;
    }
}
