package algorithm.programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        List<Integer[]> transFormNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer[] transformNum = transformNumber(numbers[i]);
            Integer[] nums = {transformNum[0], numbers[i], transformNum[1]};
            transFormNumbers.add(nums);
        }

        String returnText = transFormNumbers
                .stream()
                .sorted(((o1, o2) -> {
                    if(o1[0].intValue() == o2[0].intValue()){
                        return  o2[2].compareTo(o1[2]);
                    }else{
                        return o2[0].compareTo(o1[0]);
                    }
                }))
                .map(integers -> String.valueOf(integers[1]))
                .collect(Collectors.joining());

        return returnText.substring(0, 1).equals("0") ? "0" : returnText;
    }

    private static Integer[] transformNumber(int number){
        Integer[] returnArr = new Integer[2];
        String[] numArr = new String[4];
        String[] strToNum = String.valueOf(number).split("");

        int bootFlag = 0;
        for (int i = 0; i < numArr.length; i++) {
            int textSize = strToNum.length -1;

            if(textSize >= i){
                numArr[i] = strToNum[i];
                if(textSize == i &&
                        i != 0 &&
                        Integer.parseInt(numArr[i-1]) < Integer.parseInt(numArr[i])){
                    bootFlag = 1;
                }
            }

            if(textSize < i){
                numArr[i] = strToNum[0];
            }
        }

        returnArr[0] = Integer.parseInt(Arrays.stream(numArr).collect(Collectors.joining()));
        returnArr[1] = bootFlag;
        return returnArr;
    }
}
