package Lab;

public class Team {
    private Coach coach;
    private Player[] squad;
    private int playerCount = 0;
    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Player[] getSquad() {
        return squad;
    }

    public void setSquad(Player[] squad) {
        this.squad = squad;
    }

    public Team(int squadCapacity){
        squad = new Player[squadCapacity];
    }
    public void addPlayer (Player player){
        if (playerCount>=squad.length) {
            System.out.println("squad is full");
        }
        else {
            squad[playerCount] = player;
            //squad[playerCount].setGoalkeepingSkill(player.getGoalkeepingSkill());
            //squad[playerCount].setAttackingSkill(player.getAttackingSkill());
            //squad[playerCount].setDefendingSkill(player.getDefendingSkill());
            playerCount++;
        }
    }
    public int teamSkill(){
        int x = 0;
        for (int i=0;i<playerCount;i++){
            x += squad[i].overallSkill();
        }
        x *= coach.getCoachingSkill();
        return x;
    }
}
