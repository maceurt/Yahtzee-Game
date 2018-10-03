import java.io.*;
import java.util.*;

public class ScoreCard {

    String[] bottom_scores_map = {"1 total", "2 total", "3 total", "4 total", "5 total", "6 total", "3 of a kind", "4 of a kind",
            "full house", "small straight", "large straight", "yahtzee", "chance"};
    int[] totals = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int total_score = 0;

    public static void main() {
        System.out.println("Hello World");
    }

    public void print_card() {
        String t_num = "";
        for (int j = 0; j < 13; j++) {
            t_num = Integer.toString(this.totals[j]);
            if (t_num.equals("-1")) {
                t_num = " ";
            }
            System.out.println("POSITION " + Integer.toString(j + 1) + " - " + this.bottom_scores_map[j] + ": " + t_num);
        }
        //System.out.println("POSITION 12 - " + " Yahtzee " + )
    }

    public int get_final_score() {
        int top_score = 0;
        for (int i = 0; i < 6; i++) {
            if (this.totals[i] != -1) {top_score += this.totals[i];}

        }
        if (top_score >= 63) {
            top_score += 35;
        }
        for (int i = 6; i < 13; i++) {
            if (this.totals[i] != -1) {top_score += this.totals[i];}
        }
        return top_score;
    }

    public int get_total_dice(ArrayList<Integer> dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            score += dice.get(i);
        }
        System.out.println(score);
        return score;
    }
    public int get_score_roll(ArrayList<Integer> dice, int space) {
        int score = 0;
        if (space <= 6) {
            for (int i = 0; i < 5; i++) {
                if (dice.get(i) == space) { score += space; }
            }
        } else if (space == 7 || space == 8) {
            for (int i = 0; i < 3; i++) {
                int g = 1;
                for (int j = (i + 1); j < 5; j++) {
                    if (dice.get(j) == dice.get(i)) { g++; }
                    if ((space == 7 && g >= 3) || (space == 8 && g >= 4)) { return this.get_total_dice(dice); }
                }
            }
        } else if (space == 9) {
            int temp1 = dice.get(0);
            int temp2 = -1;
            for (int i = 1; i < 5; i++) {
                if (temp2 == -1 && temp1 != dice.get(i)) { temp2 = dice.get(i); }
                else if (temp1 != dice.get(i) && temp2 != dice.get(i)) { return 0; }
            }
            return 25;
        } else if (space == 10 || space == 11) {
            Collections.sort(dice);
            int times = 0;
            for (int i = 0; i < 4; i++) {
                if ((dice.get(i) + 1) != dice.get(i + 1)) {
                    times += 1;
                }
            }
            if (space == 10 && times <= 1) {
                score = 30;
            }
            else if (space == 11 && times <= 0) {
                score = 40;
            }

        } else if (space == 12) {
            for (int i = 0; i < 4; i++) {
                if (dice.get(i) != dice.get(i + 1)) {
                    return 0;
                }
            }
            return 50;
        } else if (space == 13) {
            return this.get_total_dice(dice);
        }
        return score;
    }

    public void turn(ArrayList<Integer> dice) {
        this.print_card();
        System.out.println("What category do you want to put your dice total? ");
        Scanner g = new Scanner(System.in);
        int cc = g.nextInt();
        while ((cc < 1 || cc > 13) || (this.totals[cc - 1] != -1 && (cc - 1) != 12)) {
            if (cc < 1 || cc > 13) {
                System.out.println("Out of range of scorecard.");
            }
            else if (this.totals[cc] != -1) {
                System.out.println("That space on your scorecard has already been used.");
            }
            System.out.println("What category do you want to put your dice total? ");
            g = new Scanner(System.in);
            cc = g.nextInt();
        }

        if (cc == 13 && this.totals[cc - 1] != -1) {
            this.totals[cc - 1] += this.get_score_roll(dice, cc);
        }
        this.totals[cc - 1] = this.get_score_roll(dice, cc);

        System.out.printf("That dice roll in that category was worth: %d points.\n", this.totals[cc - 1]);
        return;
    }
}
