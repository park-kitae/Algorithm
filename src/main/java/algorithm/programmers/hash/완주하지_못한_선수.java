package algorithm.programmers.hash;

import java.util.Arrays;

public class 완주하지_못한_선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int size = participant.length;
        answer = search(0, size, participant, completion);

        return answer;
    }

    private static String search(int startIndex, int maxIndex, String[] participant, String[] completion){
        for (int i = startIndex; i < maxIndex; i++) {
            if(i == maxIndex -1){
                return  participant[i];
            }
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return "";
    }
}
