package LuyenTapJava.TeamPlayer;

import java.util.ArrayList;
import java.util.List;


public class SportTeam {
    private String name;
    private List<Player> teamMember = new ArrayList<>();
    private int totalWins = 0;
    private int totaLose = 0;
    private int totalTies = 0;

    public SportTeam(String name) {
        this.name = name;
    }
    public void addMember(Player player){
        if(!teamMember.contains(player)){
            teamMember.add(player);
            System.out.println("Add success: " + player);
        }else {
            System.out.println("Player exist: " + player);
        }
    }
    public void listTeamMember(){
        System.out.println("Team Baseball name: " + name);
        System.out.println(teamMember);
    }
    public int ranking(){
        return totalTies + 2 * totaLose +1;
    }

    public String setScore(int ourScore, int theirScore){
        String message = "Lose";
        if(ourScore > theirScore){
            totalWins++;
            message = "Win";
        }else if(ourScore == theirScore){
            totalTies ++;
            message = "Ties";
        }else {
            totaLose++;
        }
        return message;
    }

    @Override
    public String toString() {
        return name + " (Ranked: " + ranking() + ")";
    }

}
