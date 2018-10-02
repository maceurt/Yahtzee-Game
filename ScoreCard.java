

import java.io.*;
import java.util.*;

public class ScoreCard {

    String[] bottom_scores_map = {"3 of a kind", "4 of a kind", "full house", "small straight", "large straight"};
    int[] top_scores = {-1, -1, -1, -1, -1, -1};
    int[] bottom_scores = {-1, -1, -1, -1, -1};
    ArrayList<Integer> yahtzee_scores = new ArrayList<Integer>();
    int total_score = 0;

    public static void main() {
        System.out.println("Hello World");
    }

    public void print_card() {
        String t_num = "";
        for (int i = 0; i < 6; i++) {
            t_num = Integer.toString(top_scores[i]);
            if (t_num == "-1") {
                t_num = " ";
            }
            System.out.println("POSITION " + Integer.toString(i + 1) + " - " + Integer.toString(i + 1) + ": " + t_num);
        }
        for (int j = 0; j < 5; j++) {
            t_num = Integer.toString(bottom_scores[j]);
            if (t_num == "-1") {
                t_num = " ";
            }
            System.out.println("POSITION " + Integer.toString(j + 6 + 1) + " - " + bottom_scores_map[j] + ": " + t_num);
        }
        //System.out.println("POSITION 12 - " + " Yahtzee " + )
    }

    public void turn(ArrayList<Integer> dice) {
        this.print_card();
        System.out.println("What category do you want to put your dice total? ");
        return;
    }
}
