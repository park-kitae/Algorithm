package algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 후위표기식 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
    }

    public static String solution(String str){
        String returnStr = "";
        String[] split = str.split("");

        Stack<String> checkStack = new Stack<>();

        for (int i = 0; i < split.length; i++) {
            String item = split[i];

            if(isNotCheck(item)){
                returnStr += item;
                continue;
            }

            if(item.equals("(")){
                checkStack.add(item);
            } else if(item.equals(")")){
                returnStr += getPop(checkStack, null, true);
            }else{
                returnStr += getPop(checkStack, item,false);
                checkStack.add(item);
            }
        }
        returnStr += getPop(checkStack, null, false);

        return returnStr;
    }

    public static String getPop(Stack<String> checkStack, String insert, boolean isClose){
        String returnStr = "";
        while (!checkStack.isEmpty()){
            String peek = checkStack.peek();

            if(peek.equals("(")) {
                if(isClose) checkStack.pop();
                break;
            }

            if(isChange(insert, peek)){
                returnStr += checkStack.pop();
            }else break;
        }
        return returnStr;
    }

    public static boolean isNotCheck(String str){
        String[] check = {"(",")","+","-","*","/"};
        return !Arrays.stream(check).anyMatch(str::equals);
    }

    public static boolean isChange(String insert, String peekStr){
        if(insert == null) return true;
        if(peekStr.equals("(") || peekStr.equals(")")) return false;
        if(insert.equals("*") || insert.equals("/")) {
            if(peekStr.equals("+") || peekStr.equals("-")){
                return false;
            }
            return true;
        }
        if(insert.equals("+") || insert.equals("-")) return true;
        return false;
    }
}
