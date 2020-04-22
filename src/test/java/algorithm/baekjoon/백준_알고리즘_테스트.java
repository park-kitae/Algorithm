package algorithm.baekjoon;

import org.junit.jupiter.api.Test;

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

}
