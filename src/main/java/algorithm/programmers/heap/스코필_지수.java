package algorithm.programmers.heap;

import java.util.Stack;

public class 스코필_지수 {
    public static void main(String[] args) {
        //int[] scoville = {1,2,3,9,10,12};
        //System.out.println(solution(scoville, 1444445));
        System.out.println("Hello World!");
    }

    public static int solution(int[] scoville, int K){
        if(scoville.length == 1){
            return scoville[0] > K ? 1 : -1;
        }

        Stack<Integer> foodList = new Stack<>();
        for (int i = scoville.length -1; i >= 0; i--) {
            foodList.add(scoville[i]);
        }

        int count = 0;
        while (foodList.size() >= 2){
            int fFood = foodList.pop();
            int sFood = foodList.pop();

            int cal = fFood < sFood ? fFood + (sFood*2) : sFood + (fFood*2);

            if(cal > K){
                return count + 1;
            }

            foodList.add(cal);
            count++;
        }

        return -1;
    }

}
