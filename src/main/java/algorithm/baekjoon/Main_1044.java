package algorithm.baekjoon;

import java.util.Scanner;

public class Main_1044 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int player;
        int coach = 2;
        String[] rank = new String[2];
        player = sc.nextInt();

        int player_number = 0, coach_number = 0;
        while (sc.hasNext()){
            rank[coach_number] = player_number == 0 ?  sc.next() : rank[coach_number] + " " + sc.next();
            player_number++;

            if(player_number == player) {
                coach_number++;
                player_number = 0;
            }
        }

        String[] coachNumber = rank[0].split(" ");
        String[] coachNumber2 = rank[1].split(" ");

        int[] player_rank = new int[player];
        for (int i = 0; i < player; i++) {
            player_rank[i] = Integer.parseInt(coachNumber[i]) + Integer.parseInt(coachNumber2[i]);
        }

        int[] team = new int[player];
        boolean teamFlag = true;
        int prev_lower = 0, prev_top = 1000;
        for (int j = 0; j < player/2; j++) {
            int lower = 1000, top = 0;
            int lower_position = 0, top_position = 0;
            for (int i = 0; i < player; i++) {
                if(player_rank[i] < lower && player_rank[i] > prev_lower){
                    lower = player_rank[i];
                    lower_position = i;
                }

                if(player_rank[i] > top && player_rank[i] < prev_top){
                    top = player_rank[i];
                    top_position = i;
                }
            }

            prev_lower = player_rank[lower_position];
            prev_top = player_rank[top_position];

            team[lower_position] = teamFlag ? 1 : 2;
            team[top_position] = teamFlag ? 1 : 2;
            teamFlag = teamFlag ? false : true;
        }

        for (int i = 0; i < team.length; i++) {
            System.out.print(team[i] + " ");
        }
    }
}