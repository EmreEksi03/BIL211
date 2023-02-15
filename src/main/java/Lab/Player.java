package Lab;

public class Player extends Staff{
    private int attackingSkill;
    private int defendingSkill;
    private int  goalkeepingSkill;

    public int getAttackingSkill() {
        return attackingSkill;
    }

    public void setAttackingSkill(int attackingSkill) {
        if (attackingSkill>=1&&attackingSkill<=5)
            this.attackingSkill = attackingSkill;
        else {
            System.out.println("invalid skill value");
            this.attackingSkill = 1;
        }
    }

    public int getDefendingSkill() {
        return defendingSkill;
    }

    public void setDefendingSkill(int defendingSkill) {
        if (defendingSkill>=1&&defendingSkill<=5)
            this.defendingSkill = defendingSkill;
        else {
            System.out.println("invalid skill value");
            this.defendingSkill = 1;
        }
    }

    public int getGoalkeepingSkill() {
        return goalkeepingSkill;
    }

    public void setGoalkeepingSkill(int goalkeepingSkill) {
        if (goalkeepingSkill>=1&&goalkeepingSkill<=5)
            this.goalkeepingSkill = goalkeepingSkill;
        else {
            System.out.println("invalid skill value");
            this.goalkeepingSkill = 1;
        }
    }


    public int overallSkill(){
        return  attackingSkill + defendingSkill + goalkeepingSkill;
    };
}
