package LuyenTapJava.TeamPlayer;

record BaseballPlayer(String name, String position) implements Player{

};

record FootballPlayer(String name, String position) implements Player{

};

public class Main {
    public static void main(String[] args) {
        BaseballTeam teamA = new BaseballTeam("Team A");
        BaseballTeam teamB = new BaseballTeam("Team B");
        scoreResult(teamA, teamB, 5, 3);

        BaseballPlayer player1 = new BaseballPlayer("Player 1", "position 1");
        BaseballPlayer player2 = new BaseballPlayer("Player 2", "position 2");
        teamA.addMember(player1);
        teamA.addMember(player1);
        teamA.addMember(player2);
        teamA.listTeamMember();

        SportTeam teamC = new SportTeam("Team C");
        SportTeam teamD = new SportTeam("Team D");
        scoreResult(teamC, teamD, 5, 3);
        teamC.addMember(player1);
        teamC.addMember(player2);

        Team teamE = new Team("Team E");
        Team teamF = new Team("Team F");
        scoreResult(teamC, teamD, 5, 3);
        teamE.addMember(player1);
        teamF.addMember(player2);

        FootballPlayer footballPlayer1 = new FootballPlayer("football1", "position 1");
        FootballPlayer footballPlayer2 = new FootballPlayer("football2", "position 2");

        var haNoi = new Affiliation("Ha Noi", "City", "100000");
        Team<FootballPlayer, Affiliation> teamM = new Team<>("Team M", haNoi);
        Team<FootballPlayer, Affiliation> teamN = new Team<>("Team N", haNoi);
        teamM.addMember(footballPlayer1);
        teamM.addMember(footballPlayer2);
        scoreResult(teamM, teamN, 5,3);
        teamM.addMember(footballPlayer2);
        teamM.listTeamMember();
        var footballPlayer3 = new FootballPlayer("football3", "position 3");



//        Team<String> stringTeam1 = new Team<>("Team Str1");
//        Team<String> stringTeam2 = new Team<>("Team Str2");
//        stringTeam1.addMember("A");
//        stringTeam2.addMember("B");
//        scoreResult(stringTeam1, stringTeam2, 3,5);

    }
    public static void scoreResult(BaseballTeam baseballTeam1, BaseballTeam baseballTeam2, int scoreTeam1, int scoreTeam2){
        String message = baseballTeam1.setScore(scoreTeam1, scoreTeam2);
        baseballTeam2.setScore(scoreTeam2, scoreTeam1);
        System.out.printf("%s %s %s %n".formatted(baseballTeam1, message, baseballTeam2));
    }
    public static void scoreResult(SportTeam baseballTeam1, SportTeam baseballTeam2, int scoreTeam1, int scoreTeam2){
        String message = baseballTeam1.setScore(scoreTeam1, scoreTeam2);
        baseballTeam2.setScore(scoreTeam2, scoreTeam1);
        System.out.printf("%s %s %s %n".formatted(baseballTeam1, message, baseballTeam2));
    }

    public static void scoreResult(Team team1, Team team2, int scoreTeam1, int scoreTeam2){
        String message = team1.setScore(scoreTeam1, scoreTeam2);
        team2.setScore(scoreTeam2, scoreTeam1);
        System.out.printf("%s %s %s %n".formatted(team1, message, team2));
    }
}
