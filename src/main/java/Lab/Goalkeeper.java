package Lab;

public class Goalkeeper extends Player{
    private int reflexSkill;

    public int getReflexSkill() {
        return reflexSkill;
    }

    public void setReflexSkill(int reflexSkill) {
        if (reflexSkill>=1&&reflexSkill<=5)
            this.reflexSkill = reflexSkill;
        else {
            System.out.println("invalid skill value");
            this.reflexSkill = 1;
        }
    }

    public int overallSkill(){
        return getAttackingSkill() + getDefendingSkill() + getGoalkeepingSkill() + reflexSkill;
    };
}
