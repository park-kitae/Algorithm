package algorithm.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 정렬 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> sort = new ArrayList<>();
        while (sc.hasNext()){
            sort.add(sc.nextInt());
        }

        Collections.sort(sort);
        for (Integer i: sort) {
            System.out.println(i);
        }
        int[] sorted = new int[sort.size()];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = sort.get(i);
        }


        sort(sorted, 0, sorted.length-1);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }

    public static int[] selectSort(int[] sorted){
        for (int i = 0; i < sorted.length -1; i++) {
            int index = i;
            for (int j = i+1; j < sorted.length; j++) {
                if(sorted[index] > sorted[j]){
                    index = j;
                }
            }
            int temp = sorted[index];
            sorted[index] = sorted[i];
            sorted[i] = temp;
        }

        return sorted;
    }

    public static void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }

}
