package Lab;

public class Test {

    public static void main(String[] args) {


        Attacker attacker = (Attacker) createPlayers("Attacker", "player1", 4, 3, 2, 1);
        Defender defender = (Defender) createPlayers("Defender", "player1", 3, 3, 2, 7);
        Goalkeeper goalkeeper = (Goalkeeper) createPlayers("Goalkeeper", "player1", 1, 2, 3, 4);
        Coach coach = new Coach();
        coach.setName("coach");
        coach.setCoachingSkill(3);

        Team team = new Team(3);
        team.setCoach(coach);
        team.addPlayer(attacker);
        team.addPlayer(defender);
        team.addPlayer(goalkeeper);
        team.addPlayer(attacker);

        System.out.println(team.teamSkill());

    }


    public static Player createPlayers(String position, String name, int attackingSkill, int defendingSkill, int goalkeepingSkill, int positionSkill){
        Player player;
        if (position.equals("Attacker")) {
            player = new Attacker();
            player = (Attacker) player;
            ((Attacker) player).setShootingSkill(positionSkill);
        }
        else if (position.equals("Defender")) {
            player = new Defender();

            player = (Defender) player;
            ((Defender) player).setStrengthSkill(positionSkill);
        }
        else {
            player = new Goalkeeper();

            player = (Goalkeeper) player;
            ((Goalkeeper) player).setReflexSkill(positionSkill);
        }

        player.setName(name);
        player.setAttackingSkill(attackingSkill);
        player.setDefendingSkill(defendingSkill);
        player.setGoalkeepingSkill(goalkeepingSkill);

        return player;


    }
}



