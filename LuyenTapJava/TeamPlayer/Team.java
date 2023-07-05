package LuyenTapJava.TeamPlayer;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode){
    @Override
    public String toString() {
        return name + " (" + type + "in " + countryCode + ")";
    }
}

public class Team <T extends Player, S>{
    private String name;
    private List<T> teamMember = new ArrayList<>();
    private int totalWins = 0;
    private int totaLose = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, S affiliation) {
        this.name = name;
        this.affiliation = affiliation;
    }

    public void addMember(T t){
        if(!teamMember.contains(t)){
            teamMember.add(t);
            System.out.println("Add success: " + t);
        }else {
            System.out.println("t exist: " + t);
        }
    }
    public void listTeamMember(){
        System.out.println("Team Baseball name: " + name);
        System.out.println((affiliation == null ? "" : "Affiliation: " + affiliation));
        for (T t : teamMember){
            System.out.println(t.name());
        }
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
