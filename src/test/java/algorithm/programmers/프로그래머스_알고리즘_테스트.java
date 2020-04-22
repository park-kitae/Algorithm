package algorithm.programmers;

import algorithm.programmers.hash.완주하지_못한_선수;
import algorithm.programmers.sort.K번째수;
import algorithm.programmers.sort.가장큰수;
import algorithm.programmers.stack.송전탑_전송;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 프로그래머스_알고리즘_테스트 {

    @Test
    public void K번째수(){
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3,},{4,4,1},{1,7,3}};
        int[] result = {5,6,3};
        assertArrayEquals(result, K번째수.solution(array, commands));
    }

    @Test
    public void 가장큰수(){
        int[] example1 = {6,10,2};
        assertEquals("6210", 가장큰수.solution(example1));

        int[] example2 = {3,30,34,5,9};
        assertEquals("9534330", 가장큰수.solution(example2));

        int[] example3 = {334,3343};
        assertEquals("3343343", 가장큰수.solution(example3));

        int[] example4 = {21,212};
        assertEquals("21221", 가장큰수.solution(example4));
    }

    @Test
    public void 완주하지_못한_선수(){
        String[] example1 = {"leo", "kiki", "eden"};
        String[] example1_1 = {"eden", "kiki"};
        assertEquals("leo", 완주하지_못한_선수.solution(example1, example1_1));

        String[] example2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] example2_1 = {"josipa", "filipa", "marina", "nikola"};
        assertEquals("vinko", 완주하지_못한_선수.solution(example2, example2_1));
    }

    @Test
    public void 송전탑_전송(){
        int[] example = {6,9,5,7,4};
        int[] result = {0,0,2,2,4};
        assertArrayEquals(result, 송전탑_전송.solution(example));
    }

}
