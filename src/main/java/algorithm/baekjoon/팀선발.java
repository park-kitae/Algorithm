package algorithm.baekjoon;

import java.util.Scanner;

public class 팀선발 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int player;
        int coach = 2;
        player = sc.nextInt();
        int[][] rank = new int[coach][player];

        int player_number = 0, coach_number = 0;
        while (sc.hasNext()){
            rank[coach_number][player_number] = sc.nextInt();
            player_number++;

            if(player_number == player) {
                coach_number++;
                player_number = 0;
                if(coach_number >= coach) break;
            }
        }

        int[] result = solution(player, rank[0], rank[1]);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }


    public static int[] solution(int player, int[] rank1, int[] rank2){
        int[] player_rank = new int[player];
        for (int i = 0; i < player; i++) {
            player_rank[i] = rank1[i] + rank2[i];
        }

        int[] team = new int[player];
        boolean teamFlag = true;
        for (int j = 0; j < player/2; j++) {
            int lower = 1000, top = 0;
            int lower_position = -1, top_position = -1;
            for (int i = 0; i < player; i++) {
                /**
                 * 여기 루프가 끝날때 해당 배열의 최대값 과 최소값 위치를 가져 와야 한다
                 * 문제점: lower_position 이 할당이 되더라도 최종 lower_position이 아니기 때문에 i!= lower_position 비교가 의미 없음
                 */
                if(player_rank[i] < lower && player_rank[i] != -1){
                    lower = player_rank[i];
                    lower_position = i;
                }

                if(player_rank[i] > top && player_rank[i] != -1 && i != lower_position){
                    top = player_rank[i];
                    top_position = i;
                }
            }
            player_rank[lower_position] = -1;
            player_rank[top_position] = -1;

            team[lower_position] = teamFlag ? 1 : 2;
            team[top_position] = teamFlag ? 1 : 2;
            teamFlag = teamFlag ? false : true;

            lower_position = -1;
        }

        return team;
    }
}