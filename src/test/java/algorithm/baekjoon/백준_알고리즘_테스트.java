package algorithm.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 백준_알고리즘_테스트 {

    @Test
    public void 후위표기식(){
        String[] example = {
            "A+B*C-D/E", "(A+(B*C))-(D/E)", "((A+(B*C))-(D*E))+(F*G)",
            "A+B*C-D*E+F*G", "A+((B*C)/D)", "A+B*C/D"
        };

        String[] result = {
            "ABC*+DE/-", "ABC*+DE/-", "ABC*+DE*-FG*+",
            "ABC*+DE*-FG*+", "ABC*D/+", "ABC*D/+"
        };

        for (int i = 0; i < example.length; i++) {
            assertEquals(result[i], 후위표기식.solution(example[i]));
        }
    }

    @Test
    public void 팀선발(){
        int[] rank1 = {2,3,4,7};
        int[] rank2 = {2,4,5,8};
        int[] result = {1,2,2,1};
        assertArrayEquals(result, 팀선발.solution(4, rank1, rank2));

        int[] rank1_2 = {1,1,1,1};
        int[] rank2_2 = {3,2,2,3};
        int[] result2 = {1,1,2,2};
        assertArrayEquals(result2, 팀선발.solution(4, rank1_2, rank2_2));
    }

}
